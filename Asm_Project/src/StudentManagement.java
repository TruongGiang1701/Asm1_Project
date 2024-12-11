class StudentManagement {
    private StudentStack students = new StudentStack();

    public void addStudent(Student student) {
        this.students.push(student);
        System.out.println("Added: " + student);
    }

    public void updateStudent(String id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;
        while (!this.students.isEmpty()) {
            Student student = this.students.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            this.students.push(tempStack.pop());
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            System.out.println("Student with ID " + id + " has been updated.");
        }
    }

    public Student searchStudent(String id) {
        StudentStack tempStack = new StudentStack();
        Student foundStudent = null;
        while (!this.students.isEmpty()) {
            Student student = this.students.pop();
            if (student.getId().equals(id)) {
                foundStudent = student;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            this.students.push(tempStack.pop());
        }
        if (foundStudent == null) {
            System.out.println("Student with ID " + id + " not found.");
        }
        return foundStudent;
    }

    public void deleteStudent(String id) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;
        while (!this.students.isEmpty()) {
            Student student = this.students.pop();
            if (!student.getId().equals(id)) {
                tempStack.push(student);
            } else {
                found = true;
            }
        }
        while (!tempStack.isEmpty()) {
            this.students.push(tempStack.pop());
        }
        if (found) {
            System.out.println("Deleted student with ID " + id);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayStudents() {
        this.students.displayStudents();
    }

    public void sortStudents(int numStudents) {
        Student[] studentArray = new Student[numStudents];
        StudentStack tempStack = new StudentStack();
        for (int i = 0; i < numStudents && !this.students.isEmpty(); i++) {
            studentArray[i] = this.students.pop();
            tempStack.push(studentArray[i]);
        }
        while (!tempStack.isEmpty()) {
            this.students.push(tempStack.pop());
        }

        long startTime, endTime, duration;

        // Bubble Sort
        startTime = System.nanoTime();
        bubbleSort(studentArray.clone());
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bubble Sort time: " + duration + " nanoseconds");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(studentArray.clone(), 0, studentArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge Sort time: " + duration + " nanoseconds");

        // Quick Sort
        startTime = System.nanoTime();
        quickSort(studentArray.clone(), 0, studentArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sort time: " + duration + " nanoseconds");
    }

    private void bubbleSort(Student[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].getMarks() > array[j + 1].getMarks()) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void mergeSort(Student[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() <= rightArray[j].getMarks()) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void quickSort(Student[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(Student[] array, int low, int high) {
        Student pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].getMarks() <= pivot.getMarks()) {
                i++;
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

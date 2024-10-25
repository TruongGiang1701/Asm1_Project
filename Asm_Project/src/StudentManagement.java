public class StudentManagement {
    private StudentStack students = new StudentStack();

    public void addStudent(Student student) {
        this.students.push(student);
        System.out.println("Added: " + String.valueOf(student));
    }
    public void updateStudent(String id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();

        boolean found;
        Student student;
        for(found = false; !this.students.isEmpty(); tempStack.push(student)) {
            student = this.students.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
            }
        }
        while(!tempStack.isEmpty()) {
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
        Student foundStudent;
        Student student;
        for(foundStudent = null; !this.students.isEmpty(); tempStack.push(student)) {
            student = this.students.pop();
            if (student.getId().equals(id)) {
                foundStudent = student;
            }
        }
        while(!tempStack.isEmpty()) {
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

        while(!this.students.isEmpty()) {
            Student student = this.students.pop();
            if (!student.getId().equals(id)) {
                tempStack.push(student);
            } else {
                found = true;
            }
        }

        while(!tempStack.isEmpty()) {
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
}

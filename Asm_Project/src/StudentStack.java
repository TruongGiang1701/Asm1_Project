public class StudentStack {
    private Node top = null;
    private int size = 0;

    public StudentStack() {
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = this.top;
        this.top = newNode;
        ++this.size;
    }
    public Student pop() {
        if (this.isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        } else {
            Student poppedStudent = this.top.student;
            this.top = this.top.next;
            --this.size;
            return poppedStudent;
        }
    }
    public Student peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return this.top.student;
        }
    }
    public boolean isEmpty() {
        return this.top == null;
    }

    public void displayStudents() {
        if (this.isEmpty()) {
            System.out.println("No students in the stack.");
        } else {
            System.out.println("Students in Stack:");

            for(Node current = this.top; current != null; current = current.next) {
                System.out.println(current.student);
            }
        }

    }

    public int size() {
        return this.size;
    }
}

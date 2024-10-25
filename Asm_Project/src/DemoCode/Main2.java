package DemoCode;

public class Main2 {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private Node top;
    public LinkedListStack() {
        this.top = null;
    }
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
}

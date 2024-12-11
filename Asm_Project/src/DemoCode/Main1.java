package DemoCode;

public class Main1 {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Ban đầu stack rỗng
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full, cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        return stackArray[top--];
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return -1;
        }
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

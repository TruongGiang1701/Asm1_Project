package DemoCode;

public class DemoStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public DemoStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return -1;
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        }
        return -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

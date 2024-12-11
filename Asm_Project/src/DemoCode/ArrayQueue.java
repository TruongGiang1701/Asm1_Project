package DemoCode;

public class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int data) {
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }
    public int dequeue() {
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    public int peek() {
        return queue[front];
    }
    public int getSize() {
        return size;
    }

}

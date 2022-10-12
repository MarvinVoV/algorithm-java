package algorithm.datastructure.queue;

/**
 * {@index Queue implemented by array}
 *
 * @author marvin
 * @version QueueByArray.java, v 0.1 15/02/2021 5:32 下午 $
 * @link <a href="https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/"/>
 */
public class QueueByArray {
    private int capacity;
    private int front, rear, size;
    private int[] data;

    private QueueByArray() {
    }

    public QueueByArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        data = new int[this.capacity];
    }

    public boolean isFull() {
        return (this.size == this.capacity);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("OverFlow");
            return;
        }
        rear = (rear + 1) % this.capacity;
        data[rear] = item;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        int item = data[front];
        front = (front + 1) % capacity;
        this.size--;
        return item;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        return data[front];
    }

    public int getRear() {
        if (isFull()) {
            System.out.println("Overflow");
            return Integer.MIN_VALUE;
        }
        return data[rear];
    }


}

package algorithm.datastructure.deque;

/**
 * {@index Deque implemented by circle array}
 *
 * @author marvin
 * @version Deque.java, v 0.1 15/02/2021 4:26 下午 $
 * @see <a href="https://www.geeksforgeeks.org/implementation-deque-using-circular-array/"/>
 */
public class Deque {
    private static final int   MAX = 100;
    private              int[] data;
    private              int   front, rear;
    private int size;

    private Deque() {
    }

    public Deque(int size) {
        data = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    public boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow.");
            return;
        }

        // If deque is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        // front is at the first position of deque
        else if (front == 0) {
            front = size - 1;
        }
        // decrement front end by '1'
        else {
            front--;
        }
        data[front] = key;
    }

    public void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow.");
            return;
        }
        // If deque is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        // rear is at the last position of deque
        else if (rear == size - 1) {
            rear = 0;
        }
        // increment rear end by '1'
        else {
            rear++;
        }
        data[rear] = key;
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        // queue has only one element.
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // back to initial position
            if (front == size - 1) {
                front = 0;
            } else {
                // increment front by '1' to remove current front value from deque
                front++;
            }
        }
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        // queue has only one element.
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            if (rear == 0) {
                rear = size - 1;
            } else {
                rear--;
            }
        }
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow.");
            return Integer.MIN_VALUE;
        }
        return data[front];
    }

    public int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("UnderFlow");
            return Integer.MIN_VALUE;
        }
        return data[rear];
    }


}

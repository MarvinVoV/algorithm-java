package algorithm.datastructure.queue;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * Created by yamorn on 2016/4/13.
 * <p/>
 * queue is full: (rear + 1) % n == front
 * queue is empty: read == front
 */
public class CircularQueue<E> extends AbstractQueue<E> {
    private int front = 0;
    private int rear = 0;
    private Object[] elements;
    private int capacity;
    private static int DEFAULT_SIZE = 10 + 1;

    public CircularQueue() {
        super();
        this.capacity = DEFAULT_SIZE;
        elements = new Object[this.capacity];
    }

    public CircularQueue(int size) {
        super();
        this.capacity = size + 1;
        elements = new Object[this.capacity];
    }

    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing is the queue is empty
     */
    public void rotate() {
//        if (!isEmpty()) {
//            // swap rear and front
//            int temp = rear;
//            rear = front;
//            front = temp;
//        }
    }

    @Override
    public boolean add(E e) {
        if ((rear + 1) % capacity == front)
            throw new IndexOutOfBoundsException("Queue is full"); // queue is full
        elements[rear] = e;
        rear = (rear + 1) % capacity;
        return true;
    }

    // not support
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return (rear - front + capacity) % capacity;
    }


    public boolean offer(E e) {
        if ((rear + 1) % capacity == front)
            return false; // queue is full
        elements[rear++] = e;
        rear = (rear + 1) % capacity;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        Object e = elements[front];
        front = (front + 1) % capacity;
        return (E) e;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) elements[front];
    }

}

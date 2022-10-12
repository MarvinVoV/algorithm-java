package algorithm.datastructure.queue;

/**
 * {@index Queue implemented by linked list}
 *
 * @author marvin
 * @version QueueByLinkList.java, v 0.1 15/02/2021 8:53 下午 $
 * @link <a href="https://www.geeksforgeeks.org/queue-linked-list-implementation/"/>
 */
public class QueueByLinkList {
    static class Node {
        int  key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node front, rear;

    public QueueByLinkList() {
        this.front = this.rear = null;
    }

    public void enqueue(int item) {
        Node tmp = new Node(item);

        // If queue is empty, then the new node is front and rear both.
        if (this.rear == null) {
            this.front = this.rear = tmp;
            return;
        }
        // Add the new node at the end of queue and change rear
        this.rear.next = tmp;
        this.rear = tmp;
    }

    public int dequeue() {
        // queue is empty.
        if (this.front == null) {
            return Integer.MIN_VALUE;
        }

        Node tmp = this.front;
        this.front = this.front.next;

        //  If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
        }
        return tmp.key;
    }

    public int getFront() {
        if (this.front == null) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        return this.front.key;
    }

    public int getRear() {
        if (this.rear == null) {
            System.out.println("Overflow");
            return Integer.MIN_VALUE;
        }
        return this.rear.key;
    }

}

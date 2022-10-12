package algorithm.datastructure.queue;

/**
 * {@index Priority Queue implemented by linked list}
 *
 * @author hufeng
 * @version PriorityQueueByLinkedList.java, v 0.1 2021/2/17 00:08 Exp $
 * @see <a href="https://www.geeksforgeeks.org/priority-queue-using-linked-list/#:~:text=Priority%20Queue%20using%20Linked%20List%201%20push%20%28%29%3A,the%20queue%20without%20removing%20it%20from%20the%20queue./>
 */

public class PriorityQueueByLinkedList {
    public static class Node {
        int  data;
        /**
         * Lower values indicate higher priority
         */
        int  priority;
        Node next;
    }

    private Node head;

    private PriorityQueueByLinkedList() {}

    public PriorityQueueByLinkedList(Node head) {
        this.head = head;
    }


    public Node newNode(int data, int priority) {
        Node tmp = new Node();
        tmp.data = data;
        tmp.priority = priority;
        tmp.next = null;
        return tmp;
    }

    public Node pop() {
        Node tmp = head;
        head = head.next;
        return tmp;
    }

    public int peek() {
        return head.data;
    }

    public Node push(int data, int priority) {
        Node newNode = newNode(data, priority);
        // Special case: The header of list has lesser priority than new node.
        // So insert new node before head node and change head node.
        if (head.priority > priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node start = head;
            while (start.next != null && start.next.priority < priority) {
                start = start.next;
            }
            // Either at the end of the list or at the required position
            newNode.next = start.next;
            start.next = newNode;
        }
        return head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }


}

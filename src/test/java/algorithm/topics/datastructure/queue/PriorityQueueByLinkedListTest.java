package algorithm.topics.datastructure.queue;


import org.junit.jupiter.api.Test;

/**
 * @author hufeng
 * @version PriorityQueueByLinkedListTest.java, v 0.1 2021/2/17 00:33 Exp $
 */

public class PriorityQueueByLinkedListTest {
    @Test
    public void testQueue() {
        PriorityQueueByLinkedList.Node head = new PriorityQueueByLinkedList.Node();
        head.priority = 1;
        head.data = 4;
        head.next = null;

        PriorityQueueByLinkedList queue = new PriorityQueueByLinkedList(head);
        queue.push(4, 1);
        queue.push(5, 2);
        queue.push(6, 3);
        queue.push(7, 0);


        while (!queue.isEmpty()) {
            System.out.printf("peek %d%n", queue.peek());
            PriorityQueueByLinkedList.Node poppedNode = queue.pop();
            System.out.println("pop node=" + (poppedNode != null ? poppedNode.data : "null"));
        }
    }

}
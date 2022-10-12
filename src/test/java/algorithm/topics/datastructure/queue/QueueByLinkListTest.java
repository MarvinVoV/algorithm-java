package algorithm.topics.datastructure.queue;

import algorithm.datastructure.queue.QueueByLinkList;
import org.junit.jupiter.api.Test;

class QueueByLinkListTest {
    @Test
    public void testQueue() {
        QueueByLinkList q = new QueueByLinkList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        System.out.println(q.dequeue() + " dequeued from queue");
        System.out.println(q.dequeue() + " dequeued from queue");

        System.out.println("front is " + q.getFront());
        System.out.println("rear is " + q.getRear());
    }

}
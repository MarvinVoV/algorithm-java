package algorithm.topics.datastructure.queue;

import algorithm.datastructure.queue.QueueByArray;
import org.junit.jupiter.api.Test;

class QueueByArrayByArrayTest {
    @Test
    public void testQueue() {
        QueueByArray q = new QueueByArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        System.out.println(q.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + q.getFront());

        System.out.println("Rear item is " + q.getRear());
    }

}
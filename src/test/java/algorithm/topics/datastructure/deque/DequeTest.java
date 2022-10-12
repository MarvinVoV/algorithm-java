package algorithm.topics.datastructure.deque;

import algorithm.datastructure.deque.Deque;
import org.junit.jupiter.api.Test;

class DequeTest {
    @Test
    public void testDeque() {
        Deque dq = new Deque(5);

        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : " + dq.getRear());

        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " +
                dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);

        System.out.println("get front element: " + dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front element new front become : " +
                +dq.getFront());
    }
}
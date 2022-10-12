package algorithm.topics.datastructure.stack;

import algorithm.datastructure.stack.Stack;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void testStack() {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        System.out.println("pop=" + s.pop());

        System.out.println("peek=" + s.peek());

    }
}
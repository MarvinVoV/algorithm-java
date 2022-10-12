package algorithm.datastructure.stack;

/**
 * {@index Stack implemented by array}
 * <p>
 * LIFO: Last In, First Out
 *
 * @author marvin
 * @version Stack.java, v 0.1 15/02/2021 4:18 下午 $
 * @link https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 */
public class Stack {
    private int   capacity;
    private int   top;
    private int[] data;

    private Stack() {
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        data = new int[this.capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        data[++top] = item;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return data[top];
    }

    public int size() {
        return top + 1;
    }

}

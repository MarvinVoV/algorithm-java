package algorithm.datastructure.heap;

import java.util.Arrays;

public abstract class Heap {
    protected int[] data;
    protected int size;
    protected int capacity;

    protected Heap(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.size = 0;
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int leftChild(int i) {
        return 2 * i + 1;
    }

    protected int rightChild(int i) {
        return 2 * (i + 1);
    }

    protected boolean isFull() {
        return this.size >= this.capacity;
    }

    protected boolean isEmpty() {
        return this.size <= 0;
    }

    protected boolean isLeaf(int i) {
        return leftChild(i) >= this.size || rightChild(i) > this.size;
    }

    protected void swap(int a, int b) {
        int tmp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = tmp;
    }


    public abstract boolean insert(int x);

    public abstract int remove();

    public abstract void heapify(int index);


    public void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOf(this.data, this.size)));
    }

    public void printHeap() {
        for (int i = 0; i < (size / 2); i++) {
            System.out.print("Parent : " + this.data[i]);
            if (leftChild(i) < size)
                System.out.print(" Left : " + this.data[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print(" Right :" + this.data[rightChild(i)]);
            System.out.println();
        }
    }
}

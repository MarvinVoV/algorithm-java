package algorithm.topics.datastructure.heap;

/**
 * Base Min-heap
 *
 * @author marvin
 * @version MinHeap.java, v 0.1 15/02/2021 10:01 下午 $
 * @link <a href="https://www.geeksforgeeks.org/binary-heap/"/>
 */
public class MinHeap {
    /**
     * To store array of elements in heap
     */
    private int[] array;
    /**
     * max size of the heap
     */
    private int capacity;
    /**
     * Current number of elements in the heap
     */
    private int size;

    private MinHeap() {
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[this.capacity];
        this.size = 0;
    }

    /**
     * Get the Parent index for the given index.
     *
     * @param i
     * @return
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Get the left Child index for given index.
     *
     * @param i
     * @return
     */
    public int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Get the right Child index for the given index.
     *
     * @param i
     * @return
     */
    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public boolean isFull() {
        return this.size >= this.capacity;
    }

    public boolean isEmpty() {
        return this.size < 0;
    }

    private boolean isLeaf(int i) {
        return rightChild(i) >= size || leftChild(i) >= size;
    }

    private void swap(int a, int b) {
        int tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }

    public boolean insert(int element) {
        if (isFull()) {
            return false;
        }
        // First insert the new element at the end
        array[size] = element;
        int current = size;

        // Fix the min-heap property if it is violated
        while (array[current] < array[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
        return true;
    }

    /**
     * Removes and return the minimum element from heap.
     *
     * @return
     */
    public int remove() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        // Since its a min-heap, so root is minimum element.
        int popped = this.array[0];
        this.array[0] = this.array[--size];
        minHeapify(0);
        return popped;
    }

    /**
     * A recursive method to heapify a subtree with the root at given index.
     * This method assumes that the subtrees is already heapified
     *
     * @param i
     */
    private void minHeapify(int i) {
        if (isLeaf(i)) {
            return;
        }

        int l = leftChild(i);
        int r = rightChild(i);

        int smallest = i;
        if (array[l] < array[smallest]) {
            smallest = l;
        }
        if (array[r] < array[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }

    /**
     * Function to print the contents of the heap
     */
    public void printHeap() {
        for (int i = 0; i < (size / 2); i++) {
            System.out.print("Parent : " + array[i]);
            if (leftChild(i) < size)
                System.out.print(" Left : " + array[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print(" Right :" + array[rightChild(i)]);
            System.out.println();
        }
    }

    public void minHeap() {
        for (int i = ((size - 1) / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    public int[] getArray() {
        return array;
    }
}

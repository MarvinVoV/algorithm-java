package algorithm.topics.datastructure.heap;

import algorithm.datastructure.heap.MaxHeap;
import algorithm.datastructure.heap.MinHeap;
import org.junit.jupiter.api.Test;

public class HeapTest {
    @Test
    public void testMinHeap() {

        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(10);
        minHeap.insert(15);
        minHeap.insert(18);

        System.out.println("\nThe Min Value is : " + minHeap.remove());
        minHeap.printHeap();
        minHeap.printArray();

        System.out.println("\nThe Min Value is : " + minHeap.remove());
        minHeap.printHeap();
        minHeap.printArray();


    }

    @Test
    public void testMaxHeap() {
        MaxHeap maxHeap = new MaxHeap(7);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);

        System.out.println("\nThe Max Value is : " + maxHeap.remove());
        maxHeap.printHeap();
        maxHeap.printArray();

        System.out.println("\nThe Max Value is : " + maxHeap.remove());
        maxHeap.printHeap();
        maxHeap.printArray();

        System.out.println("\nThe Max Value is : " + maxHeap.remove());
        maxHeap.printHeap();
        maxHeap.printArray();
    }
}

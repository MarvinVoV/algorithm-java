package algorithm.datastructure.heap;

public class MaxHeap extends Heap {
    public MaxHeap(int capacity) {
        super(capacity);
    }

    @Override
    public boolean insert(int x) {
        if (isFull()) {
            return false;
        }
        int cur = size;
        this.data[cur] = x;

        // 当前节点比父节点大，交换
        while (this.data[cur] > this.data[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
        ++size;
        return true;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("MaxHeap is empty");
        }
        int max = this.data[0];
        this.data[0] = this.data[--size];
        heapify(0);
        return max;
    }

    /**
     * 非递归方式 堆化
     *
     * @param index 当前节点的索引
     */
    @Override
    public void heapify(int index) {
        while (true) {
            if (isLeaf(index)) {
                break;
            }
            int maxIndex = index;
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if (this.data[leftIndex] > this.data[maxIndex]) {
                maxIndex = leftIndex;
            }
            if (this.data[rightIndex] > this.data[maxIndex]) {
                maxIndex = rightIndex;
            }
            if (maxIndex == index) {
                break;
            }
            swap(maxIndex, index);
            index = maxIndex;
        }
    }
}

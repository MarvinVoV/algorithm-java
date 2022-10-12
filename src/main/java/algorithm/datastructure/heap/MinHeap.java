package algorithm.datastructure.heap;

public class MinHeap extends Heap {

    public MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    public boolean insert(int x) {
        if (isFull()) {
            return false;
        }
        int cur = size;
        this.data[cur] = x;

        while (this.data[cur] < this.data[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
        size++;
        return true;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("MinHeap is empty");
        }
        // 移除最顶上的元素
        int min = this.data[0];
        // 将最后一个元素放置在最顶的位置
        this.data[0] = this.data[--size];
        // 由上到下递归堆化
        heapify(0);
        return min;
    }

    /**
     * 最小堆的堆化
     *
     * @param index 当前节点的索引
     */
    @Override
    public void heapify(int index) {
        if (isLeaf(index)) {
            return;
        }
        int minIndex = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        // 找出父节点和左右子节点中的最小的一个
        if (this.data[leftIndex] < this.data[minIndex]) {
            minIndex = leftIndex;
        }
        if (this.data[rightIndex] < this.data[minIndex]) {
            minIndex = rightIndex;
        }
        // 说明父节点不是最小的，需要和最小的交换
        if (minIndex != index) {
            swap(minIndex, index);
            // 继续递归的向下堆化，维持最小堆得性质
            heapify(minIndex);
        }
    }
}

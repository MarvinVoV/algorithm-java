package algorithm.datastructure.graph;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * Dijkstra算法求解单源最短路径
 */
public class Dijkstra {
    /**
     * 有向有权图的邻接表示
     */
    public static class Graph {
        /**
         * 邻接表
         */
        private LinkedList<Edge> adj[];
        /**
         * 顶点的个数
         */
        private int v;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        /**
         * 添加一条边
         *
         * @param s 边的起始顶点编号
         * @param t 边的终止顶点编号
         * @param w 边的权重
         */
        public void addEdge(int s, int t, int w) {
            this.adj[s].add(new Edge(s, t, w));
        }

        /**
         * 从顶点s到顶点t的最短路径
         *
         * @param s 顶点s
         * @param t 顶点t
         */
        public void dijkstra(int s, int t) {
            // 用来还原最短路径
            int[] prev = new int[this.v];

            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < v; i++) {
                vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
            }

            // 小顶堆
            PriorityQueue queue = new PriorityQueue(this.v);
            // 标记是否进入过队列
            boolean[] inqueue = new boolean[this.v];

            // 起始顶点入队
            vertexes[s].dist = 0;
            queue.add(vertexes[s]);
            queue.printHeap();
            inqueue[s] = true;
            while (!queue.isEmpty()) {
                // 取堆顶元素并删除
                Vertex minVertex = queue.poll();
                // 最短路径产生了
                if (minVertex.id == t) {
                    break;
                }
                for (int i = 0; i < adj[minVertex.id].size(); i++) {
                    // 取出一条和minVertex相连的边
                    Edge edge = adj[minVertex.id].get(i);
                    // 和当前minVertex相连的边的另一端的顶点
                    Vertex nextVertex = vertexes[edge.tid];
                    // 从起始顶点到minVertex顶点的距离 + 当前边的距离 < 从起始顶点到nextVertex顶点的距离
                    if (minVertex.dist + edge.w < nextVertex.dist) {
                        queue.printHeap();
                        nextVertex.dist = minVertex.dist + edge.w;
                        prev[nextVertex.id] = minVertex.id;
                        if (inqueue[nextVertex.id]) {
                            // 更新队列中的dist值
                            queue.update(nextVertex);
                            queue.printHeap();
                        } else {
                            queue.add(nextVertex);
                            queue.printHeap();
                            inqueue[nextVertex.id] = true;
                        }
                    }
                }
            }

            // 输出最短路径
            print(s, t, prev);
        }

        private void print(int s, int t, int[] prev) {
            if (s == t) {
                return;
            }
            print(s, prev[t], prev);
            System.out.println("->" + t);
        }
    }

    public static class Edge {
        // 边的起始顶点编号
        public int sid;
        // 边的终止顶点编号
        public int tid;
        // 权重
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    /**
     * Vertex类是为了Dijkstra算法的实现
     */
    public static class Vertex {
        // 顶点编号ID
        public int id;
        // 从起始顶点到这个顶点的距离
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }


    // 因为Java提供的优先级队列没有暴露更新数据的接口，所以需要重新实现
    public static class PriorityQueue {
        private Vertex[] nodes;
        // 队列容量
        private int capacity;
        // 当前队列大小
        private int size;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.capacity = v;
            this.size = 0;
        }

        /**
         * 获取当前节点的parent节点的索引
         *
         * @param i
         * @return
         */
        private int parent(int i) {
            return (i - 1) / 2;
        }

        /**
         * 获取当前节点的左孩子节点索引
         *
         * @param i
         * @return
         */
        private int leftChild(int i) {
            return 2 * i + 1;
        }

        /**
         * 获取当前节点右孩子节点的索引
         *
         * @param i
         * @return
         */
        private int rightChild(int i) {
            return 2 * (i + 1);
        }

        /**
         * 是否是叶子节点
         *
         * @param i
         * @return
         */
        private boolean isLeaf(int i) {
            /*
                NOTE: 判断右子树的时候这里是 rightChild(i) > this.size； 而不是>= ,原因如下：
                    0
                  /
                  1
                 当只有两个节点的时候，判断根节点的时，右子树索引等于size，但实际是根节点
             */
            return leftChild(i) >= this.size || rightChild(i) > this.size;
        }

        /**
         * 交换索引为a和b的两个节点
         *
         * @param a
         * @param b
         */
        private void swap(int a, int b) {
            Vertex temp = nodes[a];
            nodes[a] = nodes[b];
            nodes[b] = temp;
        }

        public Vertex poll() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is Empty.");
            }
            // 移除最顶上的元素
            Vertex min = this.nodes[0];
            // 将最后一个元素放在堆顶上
            this.nodes[0] = this.nodes[--size];
            // 自上向下递归堆化
            heapify(0);
            return min;
        }

        /**
         * 自上向下递归堆化
         *
         * @param index
         */
        private void heapify(int index) {
            if (isLeaf(index)) {
                return;
            }
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            int minIndex = index;
            // 找出父子节点中最小的一个
            if (nodes[leftIndex].dist < nodes[minIndex].dist) {
                minIndex = leftIndex;
            }
            if (nodes[rightIndex].dist < nodes[minIndex].dist) {
                minIndex = rightIndex;
            }
            // 说明父节点不是最小，需要交换
            if (minIndex != index) {
                swap(minIndex, index);
                // 继续向下堆化
                heapify(minIndex);
            }
        }

        public void add(Vertex vertex) {
            if (isFull()) {
                throw new RuntimeException("Queue is Full.");
            }
            // 数组尾部添加当前元素
            int cur = this.size;
            this.nodes[cur] = vertex;
            // 由下向上调整使其符合堆定义
            while (this.nodes[cur].dist < this.nodes[parent(cur)].dist) {
                swap(cur, parent(cur));
                cur = parent(cur);
            }
            size++;
        }

        /**
         * 更新节点的值，并从下往上堆化，让其重新符合堆的定义
         *
         * @param vertex
         */
        public void update(Vertex vertex) {
            assert vertex != null;

            // 查找到当前节点的索引位置,这里先简单实现..
            int index = 0;
            for (int i = 0; i < this.size; i++) {
                if (nodes[i] == vertex) {
                    index = i;
                    break;
                }
            }
            while (index >= 0) {
                heapify(index);
                if (index == 0) {
                    break;
                }
                index = parent(index);
            }
        }

        public boolean isFull() {
            return this.size >= this.capacity;
        }

        public boolean isEmpty() {
            return this.size <= 0;
        }

        public void printHeap() {
            System.out.println("-------Heap Start----------");
            for (int i = 0; i < (size / 2); i++) {
                System.out.print("Parent : " + JSON.toJSONString(this.nodes[i]));
                if (leftChild(i) < size)
                    System.out.print(" Left : " + JSON.toJSONString(this.nodes[leftChild(i)]));
                if (rightChild(i) < size)
                    System.out.print(" Right :" + JSON.toJSONString(this.nodes[rightChild(i)]));
                System.out.println();
            }
            System.out.println("-------Heap End----------");
        }
    }

    public static void main(String[] args) {
//        PriorityQueue queue = new PriorityQueue(14);
//        Vertex updated = new Vertex(0, 4);
//        queue.add(new Vertex(0, 0));
//        queue.add(new Vertex(0, 2));
//        queue.add(new Vertex(0, 5));
//        queue.add(new Vertex(0, 9));
//        queue.add(updated);
//        queue.add(new Vertex(0, 6));
//        queue.add(new Vertex(0, 8));
//        queue.add(new Vertex(0, 10));
//        queue.add(new Vertex(0, 12));
//        queue.add(new Vertex(0, 11));
//        queue.add(new Vertex(0, 16));
//        queue.add(new Vertex(0, 17));
//        queue.add(new Vertex(0, 19));
//        queue.add(new Vertex(0, 25));
//        queue.printHeap();
//
//        updated.dist = -1;
//        queue.update(updated);
//        queue.printHeap();
//
//        Vertex popped = queue.poll();
//        System.out.println("popped: " + JSON.toJSONString(popped));
//        queue.printHeap();


        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        graph.dijkstra(0, 5);
    }
}

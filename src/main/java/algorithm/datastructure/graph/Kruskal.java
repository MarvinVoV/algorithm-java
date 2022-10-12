package algorithm.datastructure.graph;

import algorithm.datastructure.UnionFindSet;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal算法 最小生成树
 */
public class Kruskal {
    public static class Graph {
        /**
         * 顶点个数
         */
        private int v;
        /**
         * 边的个数
         */
        private int e;
        /**
         * 边
         */
        private List<Edge> edges = new ArrayList<>();
        /**
         * 最小生成树
         */
        private List<Edge> mst = new ArrayList<>();

        public Graph(int v) {
            this.v = v;
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
            this.e = this.edges.size();
        }

        public void kruskal() {
            // 并查集
            UnionFindSet unionFindSet = new UnionFindSet(v);
            // 边按照权重从小到达排序
            Collections.sort(edges);
            int count = 0;
            for (int i = 0; i < e; i++) {
                Edge edge = edges.get(i);
                boolean inSameSet = unionFindSet.find(edge.ui, edge.vi);
                if (inSameSet) {
                    continue;
                }
                mst.add(edge);
                unionFindSet.union(edge.ui, edge.vi);
                count++;
                if (count == v - 1) {
                    break;
                }
            }
            System.out.println(JSON.toJSONString(mst));
        }

        public static void main(String[] args) {
            Graph graph = new Graph(5);
            graph.addEdge(new Edge(0, 4, 1));
            graph.addEdge(new Edge(0, 1, 3));
            graph.addEdge(new Edge(1, 3, 4));
            graph.addEdge(new Edge(1, 2, 7));
            graph.addEdge(new Edge(1, 4, 6));
            graph.addEdge(new Edge(4, 3, 9));
            graph.addEdge(new Edge(2, 3, 8));
            graph.kruskal();

        }
    }

    public static class Edge implements Comparable<Edge> {
        // 边的起始点
        public int ui;
        // 边的终止点
        public int vi;
        // 边的权重
        public int weight;

        public Edge(int ui, int vi, int w) {
            this.ui = ui;
            this.vi = vi;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}

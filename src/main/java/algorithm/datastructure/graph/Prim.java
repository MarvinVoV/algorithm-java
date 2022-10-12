package algorithm.datastructure.graph;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim算法求解最小生成树
 */
public class Prim {
    public static class Graph {
        // 顶点个数
        private int v;
        // 边集合
        private List<Edge> adjs[];
        // 最小生成树
        private List<Edge> mst = new ArrayList<>();

        public Graph(int v) {
            this.v = v;
            adjs = new List[v];
            for (int i = 0; i < v; i++) {
                adjs[i] = new ArrayList<>();
            }
        }

        public void addEdge(Edge edge) {
            this.adjs[edge.vi].add(edge);
        }

        public void prim() {
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                visited[i] = false;
            }
            visited[0] = true;
            // 从顶点的边开始考察
            for (int i = 0; i < adjs[0].size(); i++) {
                Edge edge = adjs[0].get(i);
                queue.add(edge);
            }

            int selectedEdgeCount = 0;
            while (selectedEdgeCount < v - 1 && !queue.isEmpty()) {
                Edge minEdge = queue.poll();
                int unvisitedVid;
                if (visited[minEdge.vi] && visited[minEdge.vj]) {
                    continue;
                } else if (visited[minEdge.vi] && !visited[minEdge.vj]) {
                    unvisitedVid = minEdge.vj;
                } else {
                    unvisitedVid = minEdge.vi;
                }
                selectedEdgeCount++;
                mst.add(minEdge);
                visited[unvisitedVid] = true;
                for (int i = 0; i < adjs[unvisitedVid].size(); i++) {
                    Edge edge = adjs[unvisitedVid].get(i);
                    if (!visited[edge.vj]) {
                        queue.add(edge);
                    }
                }
            }
            System.out.println(JSON.toJSONString(this.mst));
        }

    }

    public static class Edge {
        public int vi;
        public int vj;
        public int weight;

        public Edge(int vi, int vj, int w) {
            this.vi = vi;
            this.vj = vj;
            this.weight = w;
        }
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
        graph.prim();

    }
}

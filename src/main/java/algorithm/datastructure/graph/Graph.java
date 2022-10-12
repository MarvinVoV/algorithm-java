package algorithm.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 */
public class Graph {
    // 顶点个数
    private int v;

    // 邻接表
    private LinkedList<Integer>[] adj;

    // 递归遍历方法中使用
    private boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图的一条边存储两次
     *
     * @param s 起始点
     * @param t 终止点
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
//        adj[t].add(s);
    }

    /**
     * 广度优先搜索(Breadth First Search)
     *
     * @param s
     * @param t
     */
    public void bsf(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 深度优先搜素 Depth First Search (DFS)
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, prev, visited);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, int[] prev, boolean[] visited) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, prev, visited);
            }
        }
    }

    /**
     * 递归输出s到t的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        StringBuilder sb = new StringBuilder();
        doPrint(prev, s, t, sb);
        System.out.println(sb);
    }

    private void doPrint(int[] prev, int s, int t, StringBuilder sb) {
        if (prev[t] != -1 && t != s) {
            doPrint(prev, s, prev[t], sb);
        }
        sb.append(t).append(" ");
    }


    /**
     * Kahn 拓扑排序
     */
    public void topoSortByKahn() {
        // 入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
        System.out.println();
    }


    /**
     * 深度优先搜索实现拓扑排序
     */
    public void topoSortByDfs() {
        // 先构建逆向邻接表
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        // 通过邻接表生成逆向邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        // 深度优先遍历
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
            }
            dfs(i, inverseAdj, visited);
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bsf(0, 6);
        graph.dfs(0, 6);

        graph.topoSortByKahn();
        graph.topoSortByDfs();
    }
}

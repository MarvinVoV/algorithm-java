package algorithm.datastructure.graph;

import com.alibaba.fastjson.JSON;

public class Floyd {
    /**
     * 顶点的个数
     */
    private int v;

    /**
     * 图 g[i][j]表示顶点i到顶点j的边的权值
     */
    private int[][] g;

    /**
     * 距离 dist[i][j]表示顶点i到顶点j的最短距离
     */
    private int[][] dist;

    public Floyd(int v) {
        this.v = v;
        g = new int[v][v];
        dist = new int[v][v];
    }

    public void addEdge(int s, int t, int w) {
        g[s][t] = w;
    }

    /**
     * 动态规划
     */
    public void floyd() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = g[i][j];
            }
        }
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 1; j < v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(dist));
    }


    public static void main(String[] args) {
        Floyd floyd = new Floyd(3);
        floyd.addEdge(0, 1, 10);
        floyd.addEdge(1, 2, 15);
        floyd.addEdge(0, 2, 9);

        floyd.floyd();
    }

}

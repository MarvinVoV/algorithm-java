package algorithm.datastructure;

/**
 * 基于树实现的并查集(Union-Find Set)
 */
public class UnionFindSet {

    // 记录父节点
    private int p[];

    // 记录树的高度
    private int rank[];

    public UnionFindSet(int n) {
        p = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int r, int n) {
        if (find(r, n)) {
            return;
        }
        if (rank[r] > rank[n]) {
            p[n] = r;
        } else if (rank[r] < rank[n]) {
            p[r] = n;
        } else {
            p[n] = r;
            rank[r]++;
        }
    }

    public boolean find(int a, int b) {
        return findR(a) == findR(b);
    }

    /**
     * 查找子集的根节点
     *
     * @param i
     * @return
     */
    private int findR(int i) {
        // 判断当前元素是否是根元素
        if (p[i] != i) {
            // 回溯至根节点， 将当前节点挂在根节点下，即路径压缩
            p[i] = findR(p[i]);
        }
        return p[i];
    }

    public static void main(String[] args) {
        UnionFindSet findSet = new UnionFindSet(6);
        findSet.union(0, 2);
        findSet.union(0, 3);
        findSet.union(2, 5);
        findSet.union(1, 4);
        System.out.println(findSet.find(3, 5));
        System.out.println(findSet.find(3, 2));
        System.out.println(findSet.find(1, 4));
        System.out.println(findSet.find(1, 3));
    }
}

package algorithm.topics.dp.knapsack;

/**
 * 0/1背包问题
 *
 * @author hufeng
 * @version ZeroOneKnapsack.java, v 0.1 2018/12/6 11:57 PM Exp $
 */

public class ZeroOneKnapsack {
    /**
     * Problem: Given weights and values of n items,
     * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
     * <p>
     * Assume w1,w2...wn, W are strictly positive integers. Define m[i,w] to be the maximum value
     * that can be attained with weight less than or equals to w using items up to i (first i items).
     * We can define m[i, w] recursively as follows:
     * m[0,w] = 0
     * m[i,w] = m[i-1,w] if w[i] > w
     * m[i,w] = max(m[i-1, w], m[i-1, w-w[i]] + vi) if w[i] <= w
     *
     * @param W   knapsack capacity
     * @param wt  weight
     * @param val value
     * @param n   number of item
     * @return maximum value
     */
    public static int zeroOneKnapsack(int W, int[] wt, int[] val, int n) {
        // Build table K[][] in bottom up manner
        int[][] K = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }


    /**
     * 背包能装太最大重量
     */
    private static int maxW = Integer.MIN_VALUE;

    /**
     * 求背包中能装的最大重量
     *
     * @param i     考察到第几个物品 （0-based)
     * @param cw    当前背包中装进去的重量和
     * @param items 每个物品的重量
     * @param n     表示物品的个数
     * @param w     表示背包可承受的最大重量
     */
    public static void zeroOneKnapsackByRecur(int i, int cw, int[] items, int n, int w) {
        // cw == w 表示装满了； i == n 表示已经考察完了所有物品
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        // 选择不装当前物品，考察下一个物品
        zeroOneKnapsackByRecur(i + 1, cw, items, n, w);
        // 选择装当前物品，并考察下一个物品
        if (cw + items[i] <= w) {
            zeroOneKnapsackByRecur(i + 1, cw + items[i], items, n, w);
        }
    }


    /**
     * 求背包中能装的最大重量 - 通过备忘录来优化
     *
     * @param i     考察到第几个物品 （0-based)
     * @param cw    当前背包中装进去的重量和
     * @param items 每个物品的重量
     * @param n     表示物品的个数
     * @param w     表示背包可承受的最大重量
     */
    public static void zeroOneKnapsackByRecurWithMemo(int i, int cw, int[] items, int n, int w) {
        boolean[][] memo = new boolean[n][w + 1];
        doZeroOneKnapsackByRecurWithMemo(i, cw, items, n, w, memo);
    }

    private static void doZeroOneKnapsackByRecurWithMemo(int i, int cw, int[] items, int n, int w, boolean[][] memo) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        // 重复状态计算
        if (memo[i][cw]) {
            return;
        }
        // 记录(i, cw)状态
        memo[i][cw] = true;

        // 选择不装第i个物品
        doZeroOneKnapsackByRecurWithMemo(i + 1, cw, items, n, w, memo);

        // 选择装第i个物品
        if (cw + items[i] <= w) {
            doZeroOneKnapsackByRecurWithMemo(i + 1, cw + items[i], items, n, w, memo);
        }
    }

    public static void main(String[] args) {
        int[] items = new int[]{2, 2, 4, 6, 3};
        int n = items.length;
        int w = 9;
//        zeroOneKnapsackByRecur(0, 0, items, n, w);
        zeroOneKnapsackByRecurWithMemo(0, 0, items, n, w);
        System.out.println(maxW);
    }

}

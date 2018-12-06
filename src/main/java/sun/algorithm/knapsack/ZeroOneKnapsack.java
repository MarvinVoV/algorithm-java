package sun.algorithm.knapsack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public int zeroOneKnapsack(int W, int[] wt, int[] val, int n) {
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

    @Test
    public void testDpSolution() {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        assertEquals(220, zeroOneKnapsack(W, weight, value, value.length));

    }
}

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 *
 * @author hufeng
 * @version $Id: Triangle.java, v 0.1 2018年11月29日 9:36 PM hufeng Exp $
 */
public class Triangle {
    /**
     * 动态规划求解-Top Down version
     * 一定是自顶向下求解, 因为从最小规模的子问题求解，是局部解，但不是全局下的最优解
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return Integer.MIN_VALUE;
        }
        // init memo
        List<List<Integer>> memo = new ArrayList<>();
        for (List<Integer> row : triangle) {
            List<Integer> memoRow = new ArrayList<>(row.size());
            for (int i = 0; i < row.size(); i++) {
                memoRow.add(Integer.MIN_VALUE);
            }
            memo.add(memoRow);
        }

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                helper(triangle, i, j, memo);
            }
        }

        return memo.get(memo.size() - 1).stream().min(Integer::compareTo).orElse(Integer.MIN_VALUE);
    }

    private static int helper(List<List<Integer>> triangle, int row, int col, List<List<Integer>> memo) {
        if (memo.get(row).get(col) != Integer.MIN_VALUE) {
            return memo.get(row).get(col);
        }

        if (row == 0 && col == 0) {
            memo.get(0).set(0, triangle.get(0).get(0));
        } else if (col == 0) {
            memo.get(row).set(col, triangle.get(row).get(col) + helper(triangle, row - 1, col, memo));
        } else if (col == triangle.get(row).size() - 1) {
            memo.get(row).set(col, triangle.get(row).get(col) + helper(triangle, row - 1, triangle.get(row - 1).size() - 1, memo));
        } else {
            int leftUpper = helper(triangle, row - 1, col - 1, memo);
            int rightUpper = helper(triangle, row - 1, col, memo);
            memo.get(row).set(col, triangle.get(row).get(col) + Math.min(leftUpper, rightUpper));
        }
        return memo.get(row).get(col);

    }


    /**
     * Reference: <a href="https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle"/>
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/triangle/">Triangle</a>
 *
 * @author hufeng
 * @version $Id: Triangle.java, v 0.1 2018年11月29日 9:36 PM hufeng Exp $
 */
public class Triangle {
    /**
     * 方法一： 递归+备忘录
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
     * 方法二：动态规划 + 空间优化
     * <pre>
     * [2]
     * [3,4]
     * [6,5,7]
     * [4,1,8,3]
     * </pre>
     * <p>
     * 动态规划解题思路: 用f[i][j]表示从三角形顶部走到位置(i,j)的最小路径和。这里i,j分别表示三角形中的第i行和第j列。
     * 由于每一步只能移动到下一行「相邻的节点」上。于是状态转移方程式:
     * f[i][j] = min(f[i-1][j-1], f[i-1][j]) + c[i][j]
     * <p>
     * <p>
     * Reference: <a href="https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle"/>
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        // 从底向上操作
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * 方法三：递归求解
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        return recursion(triangle, 0, 0);
    }

    private static int recursion(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        return triangle.get(row).get(col) + Math.min(recursion(triangle, row + 1, col),
                recursion(triangle, row + 1, col + 1));
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
//        int ans = minimumTotal3(triangle);
        int ans = minimumTotal2(triangle);
        System.out.println(ans);
    }

}
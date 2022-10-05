/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum>Minimum Path Sum</a>
 *
 * @author hufeng
 * @version $Id: MinimumPathSum.java, v 0.1 2018年11月29日 8:06 PM hufeng Exp $
 */
public class MinimumPathSum {
    /**
     * 动态规划求解-自底向上求解
     * 最优子结构： 到达坐标(i,j)的最小路径和的解可以从到达(i-1, j)和到达(i,j-1)的最小路径解比较产生，即
     * pathSum(i,j) = min(pathSum(i-1,j), pathSum(i,j-1)
     * 遍历整个二维表，存储每个节点的解，最后(m,n)坐标的解便是函数的解
     *
     * @param grid input array
     * @return min path sum
     */
    public static int minPathSum(int[][] grid) {
        // row
        int m = grid.length;
        // col
        int n = grid[0].length;

        // 存放到达A[i,j]点的最短路径值
        int[][] cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cache[i][j] = grid[i][j];
                } else if (i == 0) {
                    cache[i][j] = cache[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    cache[i][j] = cache[i - 1][j] + +grid[i][j];
                } else {
                    cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + grid[i][j];
                }
            }
        }

        // print
//        for (int[] row : cache) {
//            System.out.println(JSON.toJSONString(row));
//        }
        return cache[m - 1][n - 1];
    }

    /**
     * 动态规划
     * 空间复杂度O(1),直接修改原矩阵,不使用额外空间
     *
     * @param grid
     * @return
     */
    public static int minPathSum3(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 递归+备忘录
     *
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        return helper(grid, memo, 0, 0);
    }

    private static int helper(int[][] grid, int[][] memo, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if (memo[i][j] != -1)
            return memo[i][j];
        memo[i][j] = grid[i][j];
        int rec = Math.min(helper(grid, memo, i + 1, j), helper(grid, memo, i, j + 1));
        if (rec != Integer.MAX_VALUE)
            memo[i][j] += rec;
        return memo[i][j];
    }

}
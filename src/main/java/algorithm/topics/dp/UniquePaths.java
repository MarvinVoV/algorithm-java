package algorithm.topics.dp;

/**
 * <a href="https://leetcode-cn.com/problems/unique-paths>Unique Paths</a>
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[i][j] 表示从左上角走到坐标(i,j)的路径数量, 最能走到左上角坐标(0,0)只有一种路径
        dp[0][0] = 1;
        // f[i][j] = f[i-1][j] + f[i][j-1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边界条件：当i=0或j=0时，只有一种方式到达[i][j],即要么向右，要么向下
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 走到坐标(i,j)只能从上向下移动一步 或者 从左向右移动一步
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }
}

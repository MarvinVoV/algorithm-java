package algorithm.topics.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // init
        dp[0][0] = 1;
        // f[i][j] = f[i-1][j] + f[i][j-1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边界条件：当i=0或j=0时，只有一种方式到达[i][j],即要么向右，要么向下
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
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

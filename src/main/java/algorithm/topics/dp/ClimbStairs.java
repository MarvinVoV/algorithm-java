
package algorithm.topics.dp;

/**
 * <a herf="https://leetcode.cn/problems/climbing-stairs/">Climbing Stairs</a>
 *
 * @author hufeng
 * @version $Id: ClimbStairs.java, v 0.1 2018年07月03日 下午2:20 hufeng Exp $
 */
public class ClimbStairs {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairsByDp(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归方法求解
     *
     * @param n
     * @return
     */
    public int climbStairsByRecursive(int n) {
        // - 第一级台阶: 1中方法(爬1级）
        // - 第二级台阶: 2种方法(爬1级或爬2级)
        // - 第n级台阶: 从n-1级爬1级或从n-2级爬2级
        // - 地推公式: f(n) = f(n-1) + f(n-2)
        if (n <= 2) return n;
        return climbStairsByRecursive(n - 1) + climbStairsByRecursive(n - 2);
    }

    /**
     * 记忆化递归求解
     *
     * @param n
     * @return
     */
    public int climbStairByRecursiveWithMemo(int n) {
        int[] memo = new int[n + 1];
        return climbStairMemo(n, memo);
    }

    private int climbStairMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = n;
        } else {
            memo[n] = climbStairMemo(n - 1, memo) + climbStairMemo(n - 2, memo);
        }
        return memo[n];
    }


}
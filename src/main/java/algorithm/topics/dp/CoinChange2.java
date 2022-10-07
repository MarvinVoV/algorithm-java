package algorithm.topics.dp;

/**
 * <a href="https://leetcode.cn/problems/coin-change-2>Coins Chage 2</a>
 *
 * @author marvin
 * @version CoinChange2.java, v 0.1 2022/10/07 12:52 Exp $
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // dp[x] 表示金额之和等于x的硬币组合数,目标是求dp[amount]
        // 动态规划的边界是 dp[0]=1。只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合。
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        int amount = 6;
        int[] coins = new int[]{1, 2, 5};


        CoinChange2 coinChange2 = new CoinChange2();
        int ans = coinChange2.change(amount, coins);
        System.out.println(ans);

    }
}

package algorithm.topics.dp;

/**
 * 三种硬币,分别面值 2元, 5元, 7元, 每种硬币都有足够多；
 * 买一本书需要 27元
 * 如何用最少的硬币组合正好付清，不需要对方找钱
 * <p>
 * 答案: 7 + 5 + 5 + 5 + 5
 */
public class CoinChange {

    /**
     * 最少用多少硬币拼出num
     *
     * @param num
     * @return
     */
    private static int coinChangeByRecur(int num) {
        if (num == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        // 最后一枚硬币是2元的情况
        if (num >= 2) {
            int subRes = coinChangeByRecur(num - 2) ;
            if (subRes != Integer.MIN_VALUE) {
                res = Math.min(subRes + 1, res);
            }
        }
        // 最后一枚硬币是5元的情况
        if (num >= 5) {
            int subRes = coinChangeByRecur(num - 5);
            if (subRes != Integer.MIN_VALUE) {
                res = Math.min( subRes+ 1, res);
            }
        }
        // 最后一枚硬币是7元的情况
        if (num >= 7) {
            int subRes = coinChangeByRecur(num - 7);
            if (subRes != Integer.MIN_VALUE) {
                res = Math.min( subRes+ 1, res);
            }
        }
        return res;
    }

    /**
     * 动态规划求解
     *
     * @param coins 不用硬币组合的数组 这里是 {2,5,7}
     * @param num   这里是 27
     * @return
     */
    public static int coinChangeByDp(int[] coins, int num) {
        int len = coins.length;
        int[] f = new int[num + 1];
        // init
        f[0] = 0;
        int i, j;
        // f[1], f[2], ... , f[27]
        for (i = 1; i <= num; i++) {
            f[i] = Integer.MAX_VALUE;
            // last coin coins[j]
            // f[i] = min{ f[i-coins[0] + 1, ... f[i-coins[n-1]+1}
            for (j = 0; j < len; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    // 比如拼出27，假设最后一枚是5，那么考虑拼出22的最小硬币数+1就行了，但是可能拼不出来22的最小硬币数
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[num] == Integer.MAX_VALUE) {
            f[num] = -1;
        }
        return f[num];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        int num = 27;
        int res = coinChangeByDp(coins, num);
        System.out.println(res);
        res = coinChangeByRecur(num);
        System.out.println(res);
    }

}

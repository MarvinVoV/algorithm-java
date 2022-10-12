package algorithm.topics.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/target-sum/">Target Sum</a>
 *
 * @author hufeng
 * @version TargetSum.java, v 0.1 2018-12-09 22:06 Exp $
 */

public class TargetSum {

    /**
     * 原始问题等价于： 在nums中找到一个都是正整数的子集，并且两个集合的和等于target。
     * 令P是正整数的子集，N是负数的子集
     * 如 nums=[1,2,3,4,5] target=3，那么 P=[1,3,5] N=[2,4]
     * 有一下推导:
     * <pre>
     *
     *                      sum(P)-sum(N) = target
     *    sum(P)-sum(N) + sum(P) - sum(N) = target + sum(P) - sum(N)
     *                         2 * sum(P) = target + sum(nums)
     * </pre>
     * 所以问题转化对子集求和的问题，即从nums中找到一个子集P，使得sum(P) = (target + sum(nums))/2
     * 可以参考问题 Partition-equals-subset-sum
     *
     * @param nums
     * @param S
     * @return
     * @see <a href="https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation/>
     * @see <a href="https://leetcode.com/problems/partition-equal-subset-sum/>
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) / 2);
    }

    private static int subsetSum(int[] nums, int S) {
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = S; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[S];
    }

}
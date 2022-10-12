package algorithm.topics.dp;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">Partition Equal Subset Sum</a>
 *
 * @author hufeng
 * @version PartitionEqualSubsetSum.java, v 0.1 2018/12/7 11:25 PM Exp $
 */

public class PartitionEqualSubsetSum {
    /**
     * 状态转移函数 dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]]
     *
     * @param nums
     * @return
     * @see {https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation}
     */
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(JSON.toJSON(dp[i]));
        }

        return dp[n][sum];
    }


    /**
     * 在方法1的基础上，使用一维数组进行优化
     *
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }


    /**
     * 使用递归
     *
     * @param nums
     * @return
     */
    public static boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // get sum
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) {
            return false;
        }
        return dfs(nums, nums.length - 1, sum / 2);
    }

    private static boolean dfs(int[] nums, int idx, int target) {
        if (target == 0) {
            return true;
        }
        if (idx < 0 || target < 0 || target < nums[idx]) {
            return false;
        }
        return dfs(nums, idx - 1, target - nums[idx]) || dfs(nums, idx - 1, target);
    }

}

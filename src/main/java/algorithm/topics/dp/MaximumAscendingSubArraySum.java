package algorithm.topics.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-ascending-subarray-sum>Maximum Ascending Subarray Sum</a>
 *
 * @author marvin
 * @version MaximumAscendingSubArraySum.java, v 0.1 2022/10/09 23:35 Exp $
 */
public class MaximumAscendingSubArraySum {
    /**
     * 方法一：动态规划求解
     * dp[i] 表示以nums[i] 结尾的的最长升序子数组的元素和
     * 1. 当 nums[i] > nums[i-1] 有 dp[i] = dp[i-1] + nums[i]
     * 2. 当 nums[i] <= nums[i-1] 有 dp[i] = nums[i]
     * 边界条件: i=0，此时nums[0]前面没有元素，本身可以构成一个长度为1的子数组，即dp[0] = nums[0]
     *
     * @param nums
     * @return
     */
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 方法二： 滚动数组
     *
     * @param nums
     * @return
     */
    public int maxAscendingSum2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int l = 0;
        while (l < n) {
            int sum = nums[l++];
            while (l < n && nums[l] > nums[l - 1]) {
                sum += nums[l++];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    /**
     * 方法三：双指针
     *
     * @param nums
     * @return
     */
    public int maxAscendingSum3(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, ans = 0;
        while (l < n) {
            sum = nums[l];
            for (r = l + 1; r < n && nums[r] > nums[r - 1]; r++) {
                sum += nums[r];
            }
            ans = Math.max(ans, sum);
            l = r;
        }
        return ans;

    }
}

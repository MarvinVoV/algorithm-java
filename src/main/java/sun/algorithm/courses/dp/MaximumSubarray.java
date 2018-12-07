package sun.algorithm.courses.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * <pre>
 *     Input: [-2,1,-3,4,-1,2,1,-5,4],
 *     Output: 6
 *     Explanation: [4,-1,2,1] has the largest sum = 6.
 * </pre>
 * <p>
 * Reference <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 *
 * @author hufeng
 * @version MaximumSubarray.java, v 0.1 2018/11/26 12:07 AM Exp $
 */

public class MaximumSubarray {
    /**
     * Solution1: 简单迭代 O(n)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 分析： 显然这是一个求最优解的问题，可以采用动态规划(DP)求解，最优子结构特征如下:
     * maxSubArray(A, i) = maxSubArray(A, i-1) > 0 ? maxSubArray(A, i-1) : 0 + A[i]
     * <p>
     * Reference: <a href="https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts"/>
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        // dp[i]表示 A[0...i]的最大子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void testSolution1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int result = maxSubArray(nums);
        int result = maxSubArray2(nums);

        assertEquals(6, result); // [4, -1, 2, 1]
    }
}

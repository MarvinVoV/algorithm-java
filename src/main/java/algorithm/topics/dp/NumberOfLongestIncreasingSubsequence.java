package algorithm.topics.dp;

/**
 * <a href="https://leetcode.cn/problems/number-of-longest-increasing-subsequence">Number Of Longest Increasing Subsequence</a>
 *
 * @author marvin
 * @version NumberOfLongestIncreasingSubsequence.java, v 0.1 2022/10/17 23:35 Exp $
 */
public class NumberOfLongestIncreasingSubsequence {
    /**
     * 动态规划求解
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        // 表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[n];
        // 表示以nums[i]结尾的最长上升子序列的个数
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];// 重置计数
                    } else if (dp[j] + 1 == dp[i]) { // 如 2,3,3,5
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}

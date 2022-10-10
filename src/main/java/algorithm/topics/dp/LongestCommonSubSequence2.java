package algorithm.topics.dp;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence">Longest Common SubSequence</a>
 *
 * @author marvin
 * @version LongestCommonSubSequence2.java, v 0.1 2022/10/10 23:39 Exp $
 */
public class LongestCommonSubSequence2 {
    /**
     * 方法一：动态规划
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 方法二：递归
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
            return 1 + longestCommonSubsequence(text1.substring(0, text1.length() - 1),
                    text2.substring(0, text2.length() - 1));
        } else {
            return Math.max(longestCommonSubsequence(text1, text2.substring(0, text2.length() - 1)),
                    longestCommonSubsequence(text1.substring(0, text1.length() - 1), text2));
        }
    }
}

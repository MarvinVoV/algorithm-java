package algorithm.topics.dp;

import java.util.Arrays;

/**
 * 求最长递增子序列的长度
 * The Longest Increasing Subsequence (LIS)
 *
 * @author marvin
 * @version LongestAscSubSequence.java, v 0.1 2022/04/18 22:00 Exp $
 */
public class LongestIncreasingSubSequence {

    /**
     * 方法一：递归求解LIS
     *
     * @param nums
     * @return
     */
    public static int lisByRecurse(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(lisOfIndexI(nums, i), maxLen);
        }
        return maxLen;
    }

    /**
     * 求第i个元素的LIS，其中第i个元素为lis中的最后一个元素
     *
     * @param nums
     * @param i
     * @return
     */
    private static int lisOfIndexI(int[] nums, int i) {
        if (i == 0) {
            return 1;
        }
        int maxLen = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                maxLen = Math.max(maxLen, lisOfIndexI(nums, j) + 1);
            }
        }
        return maxLen;
    }

    /**
     * 方法二：动态规划求解lis
     *
     * @param nums
     * @return
     */
    public static int lisByDp(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        // init
        Arrays.fill(lis, 1);

        // 自底向上执行
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 4, 3};
        System.out.println(lisByRecurse(nums));
        System.out.println(lisByDp(nums));

        nums = new int[]{50, 3, 10, 7, 40, 80};
        System.out.println(lisByRecurse(nums));
        System.out.println(lisByDp(nums));

        nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lisByRecurse(nums));
        System.out.println(lisByDp(nums));
    }
}

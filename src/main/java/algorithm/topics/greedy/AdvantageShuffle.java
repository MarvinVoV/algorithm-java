package algorithm.topics.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/advantage-shuffle>Advantage Shuffle</a>
 *
 * @author marvin
 * @version AdvantageShuffle.java, v 0.1 2022/10/10 00:10 Exp $
 */
public class AdvantageShuffle {
    /**
     * 方法一：贪心算法 思路参考田忌赛马
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

    /**
     * 只对nums的索引排序的实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx2[i] = i;
        }

        Arrays.sort(idx2, (a, b) -> nums2[a] - nums2[b]);
        int left = 0, right = n - 1;

        for (int num : nums1) {
            int i = num > nums2[idx2[left]] ? idx2[left++] : idx2[right--];
            ans[i] = num;
        }
        return ans;
    }
}

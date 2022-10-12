package algorithm.topics.search;

import java.util.Arrays;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1]
 * <p>
 * For example:
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/search-for-a-range/description/">Search for a Range</a>
 *
 * @author hufeng
 * @version SearchForARange.java, v 0.1 27/10/2017 1:03 AM Exp $
 */

public class SearchForARange {

    /**
     * 范围查找
     *
     * @param nums   nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int[] binarySearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return new int[]{start, end};
            } else {
                return new int[]{-1, -1};
            }
        }
        int mid = start + (end - start) / 2;

        int[] left = binarySearch(nums, start, mid, target);
        int[] right = binarySearch(nums, mid + 1, end, target);

        // 左右都没找到
        if (left[1] < 0 && right[1] < 0) {
            return new int[]{-1, -1};
        }
        // 左边没有找到，右边找到了 返回右边的值
        if (left[1] < 0) {
            return right;
        }
        //  右边没有找到，左边找到了，返回左边的值
        if (right[1] < 0) {
            return left;
        }
        return new int[]{left[0], right[1]};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }

}

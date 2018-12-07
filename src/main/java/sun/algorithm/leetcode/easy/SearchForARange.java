package sun.algorithm.leetcode.easy;

import org.junit.Test;

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
     * Runtime beats 13.19% of java submissions.
     * todo: recursive -> loop
     *
     * @param nums
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
            if (nums[start] == target)
                return new int[]{start, end};
            else
                return new int[]{-1, -1};
        }
        int mid = (start + end) / 2;

        int[] left = binarySearch(nums, start, mid, target);
        int[] right = binarySearch(nums, mid + 1, end, target);

        if (left[1] < 0 && right[1] < 0) {
            return new int[]{-1, -1};
        }
        if (left[1] < 0 && right[1] >= 0) {
            return right;
        }
        if (left[1] >= 0 && right[1] < 0) {
            return left;
        }
        return new int[]{left[0], right[1]};
    }

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8); // [3,4]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase2() {
        int[] nums = new int[]{7, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 7); // [0, 2]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{7, 7, 7, 7, 7, 7};
        int[] result = searchRange(nums, 7); // [0, 5]
        System.out.println(Arrays.toString(result));
    }


    @Test
    public void testNormalCase4() {
        int[] nums = new int[]{1, 3};
        int[] result = searchRange(nums, 1); // [0, 0]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase5() {
        int[] nums = new int[]{1};
        int[] result = searchRange(nums, 1); // [0, 0]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase6() {
        int[] nums = new int[]{1, 2};
        int[] result = searchRange(nums, 2); // [1, 1]
        System.out.println(Arrays.toString(result));
    }
}

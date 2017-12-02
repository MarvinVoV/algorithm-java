package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * <pre>
 *     Input:
 *      nums = [1, 7, 3, 6, 5, 6]
 *     Output: 3
 *     Explanation:
 *      The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 *      Also, 3 is the first index where this occurs.
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 *     Input:
 *      nums = [1, 2, 3]
 *     Output: -1
 *     Explanation:
 *      There is no index that satisfies the conditions in the problem statement.
 * </pre>
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 * <p>
 * Reference: <a href="https://leetcode.com/problems/find-pivot-index/description/">Find Pivot Index</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version FindPivotIndex.java, v 0.1 01/12/2017 11:23 PM Exp $
 */

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;

        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int j = 0; j < nums.length; j++) {
            if (leftSum == sum - leftSum - nums[j]) {
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int res = pivotIndex(nums);
        assertEquals(3, res);
    }

    @Test
    public void testNormalCase2() {
        int[] nums = new int[]{1, 2, 3};
        int res = pivotIndex(nums);
        assertEquals(-1, res);

    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{-1, -1, -1, 0, 1, 1};
        int res = pivotIndex(nums);
        System.out.println(res);

    }
}

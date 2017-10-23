package sun.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * <p>
 * Reference: <a href="https://leetcode.com/problems/rotate-array/description/">Rotate Array</a>
 *
 * @author hufeng
 * @version RotateArray.java, v 0.1 23/10/2017 9:17 PM Exp $
 */

public class RotateArray {

    /**
     * Reset directly.
     * <p>
     * This runtime beats only 9.95% java submissions. Terribly.
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || k <= 0 || k == nums.length) {
            return;
        }

        if (nums.length == 1) {
            return;
        }

        if (k > nums.length) {
            k = k % nums.length; // several circles
        }

        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        for (int i = 0; i < k; i++) {
            nums[i] = copyNums[nums.length - k + i];
        }

        for (int i = k, j = 0; i < nums.length; i++, j++) {
            nums[i] = copyNums[j];
        }
    }

    /**
     * Think of the array as a ring. and move each element in turn.
     * <p>
     * This runtime beats only 9.86% java submissions. So sad. I will cheer up.
     *
     * @param nums
     * @param k
     */
    public static void rotateMethodTwo(int[] nums, int k) {
        if (nums == null || k <= 0 || k == nums.length) {
            return;
        }

        if (nums.length == 1) {
            return;
        }

        if (k > nums.length) {
            k = k % nums.length; // several circles
        }

        int i = 0, p = 0, global = nums[0], q = 0;
        while (i < nums.length) {
            int nextPos = p + k;
            if (nextPos > nums.length - 1) {
                nextPos = nextPos % nums.length;
            }
            int temp = nums[nextPos];
            nums[nextPos] = global;
            if (nextPos == q) {
                p = q + 1;
                global = nums[p];
                ++q;
            } else {
                global = temp;
                p = p + k;
            }
            i++;
        }
    }

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = new int[]{1};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void testMultiCircleSteps() {
        int[] nums = new int[]{1, 2};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2NormalCase() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2MultiCircleSteps() {
        int[] nums = new int[]{1, 2};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2EvenCircle() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums)); // should be [5,6,1,2,3,4]
    }

    @Test
    public void test2EvenCircle2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums)); // should be [4,5,6,1,2,3]
    }

}

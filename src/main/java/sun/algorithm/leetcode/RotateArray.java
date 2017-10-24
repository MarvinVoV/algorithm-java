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
     * Using extra array. [Accepted]
     * <p>
     * We use an extra array in which we place every element of the array in the correct position. the number at index i
     * in the original array is placed at the index (i + k). Then, we copy the new array to the original one.
     * <p>
     * Complexity Analysis:
     * 1. Time complexity: O(n). One pass is used to put the numbers in the new array. And another pass to copy the new
     * array to the original one.
     * 2. Space complexity: O(n). Another array of the same size if used.
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

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
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

    /**
     * Using Cyclic Replacements. The authoritative answer.
     * <p>
     * Complexity analysis:
     * 1. Time complexity: O(n). Only one pass is used.
     * 2. Space complexity: O(1). Constant extra space is used.
     *
     * @param nums
     * @param k
     */
    public static void rotateMethodTwoOptimizing(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    /**
     * Approach#1 Brute Force
     * <p>
     * The simplest approach is to rotate all the elements of the array in k steps by rotating the elements by 1 unit
     * in each step.
     * <p>
     * Complexity Analysis
     * 1. Time Complexity: O(n * k). All the numbers are shifted by one step(O(n)) k times(O(k)).
     * 2. Space complexity: O(1). No extra space is used.
     *
     * @param nums
     * @param k
     */
    public static void rotateBruteForce(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    /**
     * Using Reverse [Accepted]
     * <p>
     * This approach is based on the fact that when we rotate the array k times, k elements from the back end of the
     * array come to the front and rest of the elements from the front shift backwards.
     * <p>
     * In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed
     * by reversing the rest n-k elements gives us the required result.
     * let n =7, k = 3
     * <p>
     * Original List                    : 1 2 3 4 5 6 7
     * After reversing all numbers      : 7 6 5 4 3 2 1
     * After reversing first k numbers  : 5 6 7 4 3 2 1
     * After revering last n-k numbers  : 5 6 7 1 2 3 4 --> Result
     *
     * @param nums
     * @param k
     */
    public static void rotateUsingReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * Reverse array
     *
     * @param nums
     * @param start
     * @param end
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
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

    @Test
    public void testBruteForce() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateBruteForce(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testCycleReplacements() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateMethodTwoOptimizing(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testUsingReverse() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateUsingReverse(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

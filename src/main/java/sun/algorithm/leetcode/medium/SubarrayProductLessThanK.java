package sun.algorithm.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * example:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * <p>
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * Note:
 * <ul>
 * <li>0 < nums.length <= 50000</li>
 * <li>0 < nums[i] < 1000</li>
 * <li>0 <= k < 10^6</li>
 * </ul>
 * <p>
 * Difficulty: Medium
 * Reference: <a href="https://leetcode.com/problems/subarray-product-less-than-k/description/"> Subarray Product Less Than K</a>
 *
 * @author hufeng
 * @version SubarrayProductLessThanK.java, v 0.1 03/11/2017 12:08 AM Exp $
 */

public class SubarrayProductLessThanK {

    /**
     * Not accepted. Time Limit Exceeded
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0 || nums.length > 50000 || k < 0 || k >= Math.pow(10, 6)) {
            return -1;
        }

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] >= 1000) {
                n = -1;
                break;
            }
            if (nums[i] < k) {
                int j = i;
                int max = 1;
                while (j >= 0) {
                    max *= nums[j];
                    if (max < k) {
                        j--;
                        n++;
                    } else {
                        break;
                    }
                }

            }
        }
        return n;
    }


    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int result = 0;
        int product = 1;
        for (int p = 0, i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (p < nums.length && product >= k) {
                product /= nums[p++];
            }
            result += i - p + 1;
        }
        return result;
    }

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        assertEquals(8, numSubarrayProductLessThanK2(nums, k));
    }

    @Test
    public void testBoundaryCase() {
        int[] nums = new int[]{1, 1, 1, 1};
        int k = 5;
        assertEquals(10, numSubarrayProductLessThanK2(nums, k));
    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        assertEquals(18, numSubarrayProductLessThanK2(nums, k));
    }

    @Test
    public void testNormalCase4() {
        int[] nums = new int[]{1, 2, 3};
        int k = 0;
//        assertEquals(367968907, numSubarrayProductLessThanK2(nums, k));
        System.out.println(numSubarrayProductLessThanK2(nums, k));
    }

}

package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * <p>
 * Reference: <a href="https://leetcode.com/problems/maximum-product-subarray/description/">Maximum Product Subarray</a>
 *
 * @author hufeng
 * @version MaximumProductSubarray.java, v 0.1 25/10/2017 10:45 PM Exp $
 */

public class MaximumProductSubarray {

    /**
     * Time Complexity: O(n)
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // store the result that is the max we have found so far.
        int r = nums[0];

        // imax/imin stores the max/min product of subarray that ends with the current number nums[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                // swap imax, imin
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }


    @Test
    public void testNormalCase() {
        int[] nums = new int[]{2, 3, -2, 4};
        int result = maxProduct(nums);
        assertEquals(result, 6);
    }

    @Test
    public void testNormalCase2() {
        int[] nums = new int[]{2, 3, -2, 4, 2};
        int result = maxProduct(nums);
        assertEquals(result, 8);
    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{2, 3, 2, 4, 1};
        int result = maxProduct(nums);
        assertEquals(result, 48);
    }

    @Test
    public void testNormalCase4() {
        int[] nums = new int[]{};
        int result = maxProduct(nums);
        assertEquals(result, 0);
    }

    @Test
    public void testNormalCase5() {
        int[] nums = new int[]{-2, 3, -4};
        int result = maxProduct(nums);
        assertEquals(result, 24);
    }


}

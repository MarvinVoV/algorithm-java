package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.medium.MaximumProductSubarray.maxProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductSubarrayTest {

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
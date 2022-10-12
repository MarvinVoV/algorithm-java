package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static algorithm.topics.arrays.SubarrayProductLessThanK.numSubarrayProductLessThanK2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarrayProductLessThanKTest {

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
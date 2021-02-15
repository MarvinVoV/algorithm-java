package algorithm.topics.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    @Test
    public void testSolution1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int result = MaximumSubarray.maxSubArray(nums);
        int result = MaximumSubarray.maxSubArray2(nums);

        assertEquals(6, result); // [4, -1, 2, 1]
    }

}
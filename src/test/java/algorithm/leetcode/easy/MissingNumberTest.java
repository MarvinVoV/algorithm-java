package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.MissingNumber.missingNumber3;
import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    public void testSolution1() {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber3(nums);
        assertEquals(8, result);
    }

}
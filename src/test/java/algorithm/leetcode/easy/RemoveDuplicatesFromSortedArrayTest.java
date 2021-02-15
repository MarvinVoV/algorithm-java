package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.RemoveDuplicatesFromSortedArray.removeDuplicates;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void testSolution1() {
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = new int[]{};
        int result = removeDuplicates(nums);
        assertEquals(result, 0);
    }


}
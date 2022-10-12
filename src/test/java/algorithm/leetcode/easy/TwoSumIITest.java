package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.topics.doublepointer.TwoSumII.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumIITest {

    @Test
    public void testSolution1() {
        int[] numbers = new int[]{2, 7, 11, 15};
//        int[] numbers = new int[]{-1, 0};
        int target = 9;
        int[] result = twoSum(numbers, target);
        assertArrayEquals(result, new int[]{1, 2});
    }

}
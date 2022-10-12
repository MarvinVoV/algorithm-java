package algorithm.leetcode.topic.dp.medium;

import org.junit.jupiter.api.Test;

import static algorithm.topics.dp.TargetSum.findTargetSumWays;
import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    public void testSolution() {
        int S = 3;
        int[] nums = {1, 1, 1, 1, 1};
        int r = findTargetSumWays(nums, S);
        assertEquals(5, r);

    }

}
package algorithm.leetcode.topic.dp.medium;

import org.junit.jupiter.api.Test;

import static algorithm.topics.dp.PartitionEqualSubsetSum.canPartition2;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartitionEqualSubsetSumTest {

    @Test
    public void testSolution() {
        int[] nums = {2, 3, 5};
        assertTrue(canPartition2(nums));
    }

}
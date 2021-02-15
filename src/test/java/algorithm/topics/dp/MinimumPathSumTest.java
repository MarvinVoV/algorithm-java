package algorithm.topics.dp;

import org.junit.jupiter.api.Test;

import static algorithm.topics.dp.MinimumPathSum.minPathSum;
import static algorithm.topics.dp.MinimumPathSum.minPathSum2;
import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

    @Test
    public void testSolution() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        assertEquals(7, minPathSum(grid));

        assertEquals(7, minPathSum2(grid));
    }

}
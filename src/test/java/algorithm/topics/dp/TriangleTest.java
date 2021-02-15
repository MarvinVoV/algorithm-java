package algorithm.topics.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithm.topics.dp.Triangle.minimumTotal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    @Test
    public void testSolution() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        assertEquals(11, minimumTotal(triangle));

    }

    @Test
    public void testSolutionCase2() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));

        assertEquals(-1, minimumTotal(triangle));

    }

}
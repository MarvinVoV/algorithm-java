package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.FindPivotIndex.pivotIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPivotIndexTest {

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int res = pivotIndex(nums);
        assertEquals(3, res);
    }

    @Test
    public void testNormalCase2() {
        int[] nums = new int[]{1, 2, 3};
        int res = pivotIndex(nums);
        assertEquals(-1, res);

    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{-1, -1, -1, 0, 1, 1};
        int res = pivotIndex(nums);
        System.out.println(res);

    }

}
package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithm.topics.search.SearchForARange.searchRange;

class SearchForARangeTest {

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8); // [3,4]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase2() {
        int[] nums = new int[]{7, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 7); // [0, 2]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase3() {
        int[] nums = new int[]{7, 7, 7, 7, 7, 7};
        int[] result = searchRange(nums, 7); // [0, 5]
        System.out.println(Arrays.toString(result));
    }


    @Test
    public void testNormalCase4() {
        int[] nums = new int[]{1, 3};
        int[] result = searchRange(nums, 1); // [0, 0]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase5() {
        int[] nums = new int[]{1};
        int[] result = searchRange(nums, 1); // [0, 0]
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNormalCase6() {
        int[] nums = new int[]{1, 2};
        int[] result = searchRange(nums, 2); // [1, 1]
        System.out.println(Arrays.toString(result));
    }

}
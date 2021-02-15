package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithm.leetcode.easy.RotateArray.*;

class RotateArrayTest {

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = new int[]{1};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void testMultiCircleSteps() {
        int[] nums = new int[]{1, 2};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2NormalCase() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2MultiCircleSteps() {
        int[] nums = new int[]{1, 2};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2EvenCircle() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums)); // should be [5,6,1,2,3,4]
    }

    @Test
    public void test2EvenCircle2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        rotateMethodTwo(nums, k);
        System.out.println(Arrays.toString(nums)); // should be [4,5,6,1,2,3]
    }

    @Test
    public void testBruteForce() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateBruteForce(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testCycleReplacements() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateMethodTwoOptimizing(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testUsingReverse() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateUsingReverse(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
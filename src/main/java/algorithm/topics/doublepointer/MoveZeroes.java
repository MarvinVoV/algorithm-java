package algorithm.topics.doublepointer;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">Move Zeros</a>
 *
 * @author marvin
 * @version MoveZeroes.java, v 0.1 2022/05/16 14:03 Exp $
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++j;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroes2(nums);
    }
}

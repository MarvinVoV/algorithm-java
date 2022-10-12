package algorithm.topics.doublepointer;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/rotate-array">Rotate Array</a>
 *
 * @author marvin
 * @version RotateArray.java, v 0.1 2022/05/16 12:28 Exp $
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k % n;
        System.out.println(offset);
        if (offset == 0) {
            return;
        }
        int[] ans = new int[n];
        System.arraycopy(nums, n - offset, ans, 0, offset);
        System.arraycopy(nums, 0, ans, offset, n - offset);
        System.arraycopy(ans, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        rotate(nums, 2);
        rotate1(nums, 2);
    }
}

package algorithm.topics.doublepointer;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 *
 * @author marvin
 * @version SquaresOfSortedArray.java, v 0.1 2022/05/16 09:35 Exp $
 */
public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-7,-3,2,3,11};
//        int[] nums = new int[]{-4,-1,0,3,10};
        int[] nums = new int[]{-5, -3, -2, -1};
        //
        System.out.println(Arrays.toString(sortedSquares(nums)));

    }
}

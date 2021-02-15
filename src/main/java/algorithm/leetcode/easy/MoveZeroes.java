/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;


/**
 * <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 *
 * @author hufeng
 * @version $Id: MoveZeroes.java, v 0.1 2018年11月21日 8:26 PM hufeng Exp $
 */
public class MoveZeroes {

    /**
     * Solution 1
     *
     * @param nums nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int p = -1, i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (p == -1) {
                    p = i;
                }
                while (++i < nums.length && nums[i] == 0) {
                    // find the first non zero num
                }
                if (i == nums.length) break;
                // swap and reset zero pointer
                nums[p] = nums[i];
                nums[i] = 0;
                while (++p <= i && nums[p] != 0) {
                    // find the first zero index
                }
            } else if (nums[i] != 0 && p != -1) {
                nums[p] = nums[i];
                nums[i] = 0;
                while (++p <= i && nums[p] != 0) {
                    // find the first zero index
                }
            }
            i++;
        }
    }

    /**
     * Solution 2
     *
     * @param nums nums
     */
    public static void moveZeros2(int[] nums) {
        int firstZeroPointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && firstZeroPointer == -1) {
                firstZeroPointer = i;
                continue;
            }
            if (nums[i] != 0 && firstZeroPointer > -1) {
                nums[firstZeroPointer] = nums[i];
                nums[i] = 0;
                firstZeroPointer++;
            }
        }
    }


}
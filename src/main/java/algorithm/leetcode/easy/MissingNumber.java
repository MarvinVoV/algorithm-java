/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 *
 * @author hufeng
 * @version $Id: MissingNumber.java, v 0.1 2018年11月22日 9:20 PM hufeng Exp $
 */
public class MissingNumber {
    /**
     * Solution 1 : Use index
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] data = new int[nums.length + 1];
        // Inflate data array zero
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }

        for (int j = 0; j < nums.length; j++) {
            data[nums[j]] = 1;
        }

        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Solution 2: Use XOR , a ^ b ^ b  = a, which means two xor operations with the same number will eliminate the number
     * and reveal the original number.
     *
     * @param nums
     * @return
     * @see <a href="https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination"/>
     */
    public static int missingNumber2(int[] nums) {
        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    /**
     * Solution 3: Binary search
     *
     * @param nums
     * @return
     */
    public static int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}
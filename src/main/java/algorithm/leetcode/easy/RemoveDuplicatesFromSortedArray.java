/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 *
 * @author hufeng
 * @version $Id: RemoveDuplicatesFromSortedArray.java, v 0.1 2018年11月22日 8:43 PM hufeng Exp $
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0, k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (k == nums[i]) {
                continue;
            }
            k = nums[i];
            if (i - p > 1) {
                nums[p + 1] = nums[i];
            }
            p++;
        }

        // print
        print(nums, p + 1);
        return p + 1;
    }

    /**
     * The same as Solution 1, but Better
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }


    private static void print(int[] nums, int len) {
        System.out.println(JSON.toJSONString(Arrays.copyOf(nums, len)));
    }


}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * <code>
 *     Given nums = [2, 7, 11, 15], target = 9,
 *     Because nums[0] + nums[1] = 2 + 7 = 9,
 *     return [0, 1].
 * </code>
 *
 * @author hufeng
 * @version $Id: TwoNum, v0.1 2017年07月19日 5:10 PM hufeng Exp $
 */
public class TwoNum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracer = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (tracer.containsKey(nums[i])) {
                return new int[]{tracer.get(nums[i]), i};
            } else {
                tracer.put(diff, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 11, 7, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}

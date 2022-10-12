/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.doublepointer;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input array is sorted</a>
 *
 * @author hufeng
 * @version $Id: TwoSumII.java, v 0.1 2018年11月22日 7:30 PM hufeng Exp $
 */
public class TwoSumII {
    /**
     * Solution1  67%
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int right = -1;
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > target) {
                right = --i;
                break;
            }
        }
        if (right == -1) {
            right = numbers.length - 1;
        }

        int[] result = new int[2];
        while (right > 0) {
            for (int i = 0; i < right; i++) {
                if (numbers[i] + numbers[right] == target) {
                    result[0] = i + 1;
                    result[1] = right + 1;
                    return result;
                } else if (numbers[i] + numbers[right] > target) {
                    break;
                }
            }
            --right;
        }
        return result;
    }

    /**
     * Solution2  67.55% Better
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[j] + numbers[i];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else i++;
        }
        return new int[]{-1, -1};
    }


}
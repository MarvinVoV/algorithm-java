/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/plus-one/description/">Plus One</a>
 *
 * @author hufeng
 * @version $Id: PlusOne.java, v 0.1 2018年07月16日 下午12:06 hufeng Exp $
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int base = digits[i];
            if (i == digits.length - 1) {
                base = digits[i] + 1;
            }
            int d = (base + carry) % 10;
            carry = (base + carry) / 10;
            stack.push(d);
        }
        // Don't forget carry
        if (carry != 0) {
            stack.push(carry);
        }
        int[] result = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }
        return result;
    }

    public static int[] plusOne2(int[] digits) {
        int carry = 0;
        int[] temp = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            if (i == digits.length - 1) {
                value = digits[i] + 1;
            }
            temp[i + 1] = (value + carry) % 10;
            carry = (value + carry) / 10;
        }
        if (carry != 0) {
            temp[0] = carry;
            return temp;
        }
        return Arrays.copyOfRange(temp,1, temp.length);
    }

    public static int[] plusOne3(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3},
                {4,3,2,1},
                {1,0},
                {9},
                {9,9}
        };
        for (int i = 0; i < nums.length;i++) {
            System.out.println(Arrays.toString(plusOne2(nums[i])));
        }
    }
}
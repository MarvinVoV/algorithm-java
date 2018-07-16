/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package sun.algorithm.leetcode.easy;

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

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{4, 3, 2, 1};
//        int[] nums = new int[]{1, 0};
//        int[] nums = new int[]{9};
        int[] nums = new int[]{9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
        System.out.println(Arrays.toString(plusOne2(nums)));
    }
}
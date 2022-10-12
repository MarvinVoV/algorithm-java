/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.math;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">Add Strings</a>
 *
 * @author hufeng
 * @version $Id: AddStrings.java, v 0.1 2018年07月11日 下午6:28 hufeng Exp $
 */
public class AddStrings {
    /**
     * 解思路: 离散数学， 任何一个整数都可以写成a = qn + d 的形式, n为进制数
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int L = arr1.length - 1;
        int R = arr2.length - 1;
        int q = 0;
        StringBuilder result = new StringBuilder();
        while (L >= 0 || R >= 0) {
            int a = L < 0 ? 0 : Integer.parseInt(String.valueOf(arr1[L]));
            int b = R < 0 ? 0 : Integer.parseInt(String.valueOf(arr2[R]));

            int d = (a + b + q) % 10;
            q = (a + b + q) / 10;
            result.append(String.valueOf(d));
            L--;
            R--;
        }
        if (q != 0) result.append(String.valueOf(q));
        return result.reverse().toString();
    }
}
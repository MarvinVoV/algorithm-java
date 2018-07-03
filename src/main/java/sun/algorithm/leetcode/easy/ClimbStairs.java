/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package sun.algorithm.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">Climbing Stairs</a>
 *
 * @author hufeng
 * @version $Id: ClimbStairs.java, v 0.1 2018年07月03日 下午2:20 hufeng Exp $
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }


}
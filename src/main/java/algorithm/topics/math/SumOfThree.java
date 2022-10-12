package algorithm.topics.math;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-three-consecutive-integers-that-sum-to-a-given-number/solution/zhao-dao-he-wei-gei-ding-zheng-shu-de-sa-f454/">Find Three Consecutive Integers That Sum to a Given Number</a>
 */
public class SumOfThree {

    /**
     * 一个num能表示为三个连续的整数之和,当且仅当num是3的倍数
     *
     * @param num
     * @return
     */
    public static long[] sumOfTree(long num) {
        if (num % 3 == 0) {
            return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
        }
        return new long[]{};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfTree(7)));
        System.out.println(Arrays.toString(sumOfTree(33)));

    }
}

package algorithm.topics.bitwise;

/**
 * <a href="https://leetcode.cn/problems/single-number/">Single Number</a>
 *
 * @author hufeng
 * @version $Id: SingleNumber.java, v 0.1 2018年07月04日 下午2:28 hufeng Exp $
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(array));
    }
}
package algorithm.leetcode.easy;

/**
 * Reference: <a href="https://leetcode.com/problems/base-7/description/">Base 7</a>
 * Difficulty: Easy
 * Given an integer, return its base 7 string representation.
 * Example 1:
 * Input: 100
 * Output: "202"
 * <p>
 * Example 2:
 * Input -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 *
 * @author hufeng
 * @version Base7.java, v 0.1 21/11/2017 10:31 PM Exp $
 */

public class Base7 {
    public static String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase7(num / 7) + num % 7;
    }


}

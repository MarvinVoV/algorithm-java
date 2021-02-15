package algorithm.leetcode.easy;

import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * <pre>
 *     Input:
 *      "abccccdd"
 *     Output:
 *      7
 *     Explanation:
 *     One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 * <p>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/longest-palindrome/description/">Longest Palindrome</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version LongestPalindrome.java, v 0.1 07/11/2017 8:55 PM Exp $
 */

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 2) {
            if (Math.abs(s.charAt(0) - s.charAt(1)) == 32) {
                return 0;
            }
            if (s.charAt(0) == s.charAt(1)) {
                return 2;
            }
            return 1;
        }


        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }


}

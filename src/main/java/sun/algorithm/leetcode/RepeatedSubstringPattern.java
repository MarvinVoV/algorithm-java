package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * <pre>
 *     Input: "abab"
 *
 *     Output: True
 *
 *     Explanation: It's the substring "ab" twice.
 * </pre>
 * <p>
 * Example 2:
 * <p>
 * <pre>
 *     Input: "aba"
 *
 *     Output: False
 * </pre>
 * <p>
 * Example 3:
 * <pre>
 *     Input: "abcabcabcabc"
 *
 *     Output: True
 *
 *     Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * </pre>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/repeated-substring-pattern/description/">Repeated Substring Pattern</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version RepeatedSubstringPattern.java, v 0.1 02/12/2017 1:13 PM Exp $
 */

public class RepeatedSubstringPattern {

    /**
     * Find the boundary from left to right repeatedly.
     * <p>
     * Runtime beats 98.28% of java submissions.
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        char last = chars[chars.length - 1];

        int i = s.indexOf(last), j = chars.length - 1;
        while (i < s.length() - 1) {
            int p = i;
            while (chars[p] == chars[j] && j > i) {
                p--;
                j--;
                if (p < 0) {
                    p = i;
                }
            }
            if (j != i) {
                j = chars.length - 1;
                i = s.indexOf(last, i + 1);
            } else {
                return p == i;
            }
        }
        return false;
    }


    @Test
    public void testNormalCase() {
        String s = "abab";
        assertTrue(repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase2() {
        String s = "abcabcabcabc";
        assertTrue(repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase3() {
        String s = "aba";
        assertTrue(!repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase4() {
        String s = "aabaaaba";
        assertTrue(repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase5() {
        String s = "aaa";
        assertTrue(repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase6() {
        String s = "ababab";
        assertTrue(repeatedSubstringPattern(s));
    }

    @Test
    public void testNormalCase7() {
        String s = "aabaaba";
        assertTrue(!repeatedSubstringPattern(s));
    }


}

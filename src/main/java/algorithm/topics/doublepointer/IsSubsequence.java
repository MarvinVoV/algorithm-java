package algorithm.topics.doublepointer;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long string,
 * and s is a short string (<=100)
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * return true
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * return false
 * <p>
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/is-subsequence/">Is SubSequence</a>
 *
 * @author hufeng
 * @version IsSubsequence.java, v 0.1 24/10/2017 11:14 PM Exp $
 */

public class IsSubsequence {

    /**
     * StackOverflowError caused by too many recursive calls.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubSequence(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            return false;
        }
        return isContains(s, 0, t, 0);
    }

    private static boolean isContains(String s, int index, String t, int start) {
        if (index >= s.length()) {
            return true;
        }
        if (start >= t.length()) {
            return false;
        }
        if (s.charAt(index) == t.charAt(start)) {
            return isContains(s, ++index, t, ++start);
        }
        return isContains(s, index, t, ++start);
    }


    /**
     * Time Complexity: O(n). n is the length of t.
     * <p>
     * Runtime beats 76.38% of java submissions.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubSequence2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}

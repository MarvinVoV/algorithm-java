package sun.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * <pre>
 *     Input:
 *      s = "aaabb", k = 3
 *
 *     Output:
 *      3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 *     Input:
 *          s = "ababbc", k = 2
 *
 *     Output:
 *          5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * </pre>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/"> Longest Substring with At Least K Repeating Characters</a>
 * Difficulty: Medium
 *
 * @author hufeng
 * @version LongestSubstringWithAtLeastKRepeatingCharacters.java, v 0.1 12/12/2017 8:53 PM Exp $
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
     * Method1: divide and conquer
     * bad
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (k <= 0 || s == null || s.length() == 0) {
            return 0;
        }

        String res = process(s, k);
        return res != null ? res.length() : 0;
    }

    private String process(String s, int k) {
        if (check(s, k)) {
            return s;
        }
        String left = process(s.substring(0, s.length() - 1), k);
        String right = process(s.substring(1, s.length()), k);
        return left.length() > right.length() ? left : right;
    }

    private boolean check(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method 2: divide and conquer
     * good
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring2(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    @Test
    public void testNormalCase() {
        String s = "aaabb";
        int k = 3;
        assertEquals(3, longestSubstring(s, k));
    }

    @Test
    public void testNormalCase2() {
        String s = "ababbc";
        int k = 2;
        assertEquals(5, longestSubstring(s, k));
    }

    @Test
    public void testNormalCase3() {
        String s = "ab";
        int k = 1;
        assertEquals(2, longestSubstring(s, k));
    }

    @Test
    public void testNormalCase4() {
        String s = "";
        int k = 1;
        assertEquals(0, longestSubstring(s, k));
    }

    @Test
    public void testNormalCase5() {
        String s = "aaabbb";
        int k = 3;
        assertEquals(6, longestSubstring(s, k));

    }

    @Test
    public void testNormalCase6() {
        String s = "a";
        int k = 1;
        assertEquals(1, longestSubstring(s, k));

    }

    @Test
    public void testNormalCase7() {
        String s = "bbaaacbd";
        int k = 3;
        assertEquals(3, longestSubstring(s, k));

    }

    @Test
    public void testNormalCase8() {
        String s = "aacbbbdc";
        int k = 2;
        assertEquals(3, longestSubstring(s, k));

    }
}

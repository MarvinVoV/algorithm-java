package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static algorithm.topics.recursion.LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithAtLeastKRepeatingCharactersTest {

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
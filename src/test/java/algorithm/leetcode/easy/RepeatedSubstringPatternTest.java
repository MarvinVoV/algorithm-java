package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.topics.strings.RepeatedSubstringPattern.repeatedSubstringPattern;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatedSubstringPatternTest {

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
        assertFalse(repeatedSubstringPattern(s));
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
        assertFalse(repeatedSubstringPattern(s));
    }

}
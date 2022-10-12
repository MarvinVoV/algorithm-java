package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.topics.hashtable.WordPattern.wordPattern;
import static org.junit.jupiter.api.Assertions.*;

class WordPatternTest {

    @Test
    public void testNormalCase() {
        String pattern = "abba";
        String str = "dog cat cat dog";
        assertTrue(wordPattern(pattern, str));

        str = "dog cat cat fish";
        assertFalse(wordPattern(pattern, str));

        pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";

        assertTrue(wordPattern(pattern, str));
    }

}
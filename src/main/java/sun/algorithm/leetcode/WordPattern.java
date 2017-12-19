package sun.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Reference: <a href="https://leetcode.com/problems/word-pattern/description/">Word Pattern</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version WordPattern.java, v 0.1 19/12/2017 8:01 PM Exp $
 */

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> index = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        }
        return true;
    }

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

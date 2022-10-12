package algorithm.topics.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Reference: <a href="https://leetcode.cn/problems/word-pattern/">Word Pattern</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version WordPattern.java, v 0.1 19/12/2017 8:01 PM Exp $
 */

public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
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

}

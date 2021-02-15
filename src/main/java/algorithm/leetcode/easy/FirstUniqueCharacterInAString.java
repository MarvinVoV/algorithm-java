package algorithm.leetcode.easy;

/**
 * Reference <a href="https://leetcode.com/problems/first-unique-character-in-a-string/description/"> First Unique Character in a String</a>
 *
 * @author hufeng
 * @version FirstUniqueCharacterInAString.java, v 0.1 19/12/2017 8:15 PM Exp $
 */

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}

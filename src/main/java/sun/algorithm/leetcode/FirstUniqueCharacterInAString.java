package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Reference <a href="https://leetcode.com/problems/first-unique-character-in-a-string/description/"> First Unique Character in a String</a>
 *
 * @author hufeng
 * @version FirstUniqueCharacterInAString.java, v 0.1 19/12/2017 8:15 PM Exp $
 */

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    @Test
    public void testNormalCase() {
        String s = "leetcode";
        assertEquals(0, firstUniqChar(s));

        s = "loveleetcode";
        assertEquals(2, firstUniqChar(s));

        s = "bd";
        assertEquals(0, firstUniqChar(s));

        s = "dacca";
        assertEquals(0, firstUniqChar(s));

        s = "cc";
        assertEquals(-1, firstUniqChar(s));
    }
}

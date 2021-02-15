package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.FirstUniqueCharacterInAString.firstUniqChar;
import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterInAStringTest {

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
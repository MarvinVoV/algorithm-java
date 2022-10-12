package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.topics.strings.StringToInteger.myAtoI;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    @Test
    public void testCaseNormal() {
        String str1 = "234";
        assertEquals(234, myAtoI(str1));

        String str2 = "-123";
        assertEquals(-123, myAtoI(str2));

        String str3 = "  xx234";
        assertEquals(0, myAtoI(str3));
    }

}
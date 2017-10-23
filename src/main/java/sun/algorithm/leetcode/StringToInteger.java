package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implement atoi to convert a string to an integer.
 * Reference: <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">String to Integer</a>
 *
 * @author hufeng
 * @version StringToInteger.java, v 0.1 17/10/2017 9:35 PM Exp $
 */

public class StringToInteger {

    /**
     * String to Integer
     *
     * Also reference: <code>java.lang.Integer#parseInt(java.lang.String, int)</code>
     *
     * @param str string
     * @return Integer value
     */
    public static int myAtoI(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        char[] sequences = str.trim().toCharArray();
        char firstChar = sequences[0];
        int sign = 1, start = 0, len = sequences.length;
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            char c = sequences[i];
            if (!Character.isDigit(c)) {
                return (int) sum * sign;
            }
            sum = sum * 10 + c - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * sign;
    }


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

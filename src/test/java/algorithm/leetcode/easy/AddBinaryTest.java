package algorithm.leetcode.easy;

import algorithm.topics.bitwise.AddBinary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    @Test
    public void testNormalCase() {
        String a = "11";
        String b = "1";
        assertEquals("100", AddBinary.addBinary(a, b));
    }

    @Test
    public void testNormalCase2() {
        assertEquals("100", AddBinary.addBinary("1", "11"));
    }

    @Test
    public void testNormalCase3() {
        assertEquals("10000", AddBinary.addBinary("1101", "11"));
    }

    @Test
    public void testNormalCase4() {
        assertEquals("10000", AddBinary.addBinary("11", "1101"));
    }

    @Test
    public void testNormalCase5() {
        assertEquals("1101", AddBinary.addBinary2("", "1101"));
    }

}
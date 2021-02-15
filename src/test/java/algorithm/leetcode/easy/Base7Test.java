package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Base7Test {
    @Test
    public void testNormalCase() {
        int num = 100;
        assertEquals("202", Base7.convertToBase7(num));
    }

}
package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.topics.doublepointer.ReverseWordsInAString.reverseWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInAStringTest {

    @Test
    public void testNormalCase() {
        String sentence = "the sky is blue";
        String result = reverseWords(sentence);
        System.out.println(sentence);
        assertEquals("blue is sky the", result);
    }

    @Test
    public void testNullCase() {
        String result = reverseWords(null);
        assertEquals("", result);
    }

    @Test
    public void testSingleWordCase() {
        String sequence = "one";
        assertEquals("one", reverseWords(sequence));
    }

    @Test
    public void testContainsMultiSpaceCase() {
        String sequence = " the sky   is blue";
        assertEquals("blue is sky the", reverseWords(sequence));
    }

}
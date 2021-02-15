package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.LongestPalindrome.longestPalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    @Test
    public void testNormalCase() {
        String s = "abccccdd";
        assertEquals(7, longestPalindrome(s));
    }

    @Test
    public void testNormalCase2() {
        String s = "Aa";
        assertEquals(0, longestPalindrome(s));
    }

    @Test
    public void testNormalCase3() {
        String s = "abbedd";
        assertEquals(5, longestPalindrome(s));
    }

    @Test
    public void testNormalCase4() {
        String s = "ccc";
        assertEquals(3, longestPalindrome(s));
    }

    @Test
    public void testNormalCase5() {
        String s = "AB";
        assertEquals(1, longestPalindrome(s));
    }

    @Test
    public void testNormalCase6() {
        String s = "Aa";
        assertEquals(0, longestPalindrome(s));

    }

    @Test
    public void testNormalCase7() {
        String s = "bb";
        assertEquals(2, longestPalindrome(s));
    }

    @Test
    public void testExtremeCondition() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        assertEquals(983, longestPalindrome(s));
    }

}
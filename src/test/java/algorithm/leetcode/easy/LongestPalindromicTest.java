package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.LongestPalindromic.longestPalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicTest {

    @Test
    public void test1() {
        String str = "babad";
        assertEquals(longestPalindrome(str), "bab");
    }

    @Test
    public void test2() {
        String str = "cbbd";
        String result = longestPalindrome(str);
        assertEquals(result, "bb");
    }

    @Test
    public void test3() {
        String str = "bb";
        String result = longestPalindrome(str);
        assertEquals(result, "bb");
    }

    @Test
    public void testNonePalindrome() {
        String str = "abcda";
        String result = longestPalindrome(str);
        assertEquals(result, "a");
    }

    @Test
    public void testTimeLimit() {
        String str = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
        String result = longestPalindrome(str);
        System.out.println(result);
    }

}
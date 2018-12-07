/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package sun.algorithm.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author hufeng
 * @version $Id: LongestPalindromic, v0.1 2017年07月21日 8:55 PM hufeng Exp $
 */
public class LongestPalindromic {

    private static String longestPalindrome(String s) {
        if (s == null)
            return null;

        if (s.length() == 1)
            return s;

        int max = 0;
        String str = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                        str = sub;
                    }
                }
            }
        }
        if (str == null) {
            str = s.substring(0, 1);
        }
        return str;
    }

    private static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() == 1)
            return true;

        char[] array = s.toCharArray();
        int mid = array.length / 2;
        for (int i = 0; i < mid; i++) {
            if (array.length % 2 == 0) {
                if (array[mid - i - 1] != array[mid + i]) {
                    return false;
                }
            } else {
                if (array[mid - i - 1] != array[mid + i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void  test1() {
        String str = "babad";
        assertTrue("bab".equals(longestPalindrome(str)));
    }

    @Test
    public void test2() {
        String str = "cbbd";
        String result = longestPalindrome(str);
        assertTrue("bb".equals(result));
    }

    @Test
    public void test3() {
        String str = "bb";
        String result = longestPalindrome(str);
        assertTrue("bb".equals(result));
    }

    @Test
    public void testNonePalindrome() {
        String str = "abcda";
        String result = longestPalindrome(str);
        assertTrue("a".equals(result));
    }

    @Test
    public void testTimeLimit() {
        String str = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
        String result = longestPalindrome(str);
        System.out.println(result);
    }

}

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package algorithm.leetcode.easy;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * @author hufeng
 * @version $Id: LongestSubString, v0.1 2017年07月20日 7:58 PM hufeng Exp $
 */
public class LongestSubString {

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        char[] seq = s.toCharArray();
        int p = 0, q = 0, span = 1;

        for ( int i = 1; i < seq.length; i++) {
            char cur = seq[i];
            int index = s.substring(p, i).indexOf(cur);
            if (index != -1) {
                p = p + index + 1;
            }
            if (i - p >= span) {
                span = i - p + 1;
                q = p;
            }
        }
        System.out.println("start = " + q  + " end= " + (span + q) + " str=" + s.substring(q, (span + q)));
        return span;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";  // abd
//        String s = "pwwkew"; // wke
//        String s = "";
//        String s = "au";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

}

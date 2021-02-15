/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;

/**
 * Reference <a href="https://leetcode.com/problems/implement-strstr/description/">28. Implement strStr()</a>
 *
 * @author hufeng
 * @version $Id: ImplementStr.java, v 0.1 2018年06月30日 下午4:29 hufeng Exp $
 */
public class ImplementStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if (needle.length() > haystack.length())
            return -1;
        if (needle.length() == 0) {
            return 0;
        }

        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();

        char first = target[0];
        int max = source.length - target.length;

        for (int i = 0; i <= max; i++) {
            // Look for first character
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }
            // Found first character, now look at the rest of v2
            if (i <= max) {
                int j = i + 1;
                int end = j + target.length - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++) ;
                // Found while string
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int data = strStr("zdfba", "ba");
        System.out.println(data);

    }
}
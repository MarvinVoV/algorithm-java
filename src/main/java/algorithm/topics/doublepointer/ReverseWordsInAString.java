package algorithm.topics.doublepointer;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example:
 * Given s ="the sky is blue"
 * return "blue is sky the".
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 *
 * @author hufeng
 * @version ReverseWordsInAString.java, v 0.1 23/10/2017 6:47 PM Exp $
 */

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] arr = s.trim().split("\\s+");
        if (arr.length == 1) {
            return arr[0];
        }

        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            // swap i and arr.len-i-1
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return String.join(" ", arr);
    }


}

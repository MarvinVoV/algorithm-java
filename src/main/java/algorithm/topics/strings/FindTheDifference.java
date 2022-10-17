package algorithm.topics.strings;

/**
 * <a href="https://leetcode.cn/problems/find-the-difference/">Find the difference</a>
 *
 * @author marvin
 * @version FindTheDifference.java, v 0.1 2022/10/18 00:31 Exp $
 */
public class FindTheDifference {
    /**
     * 首先遍历字符串s，对每个字符计数；然后再遍历字符串t，对每个字符减1，当出现负数时,当前字符即为答案
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 位运算： 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

}

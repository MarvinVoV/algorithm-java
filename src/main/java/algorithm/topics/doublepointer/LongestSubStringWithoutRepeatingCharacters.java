package algorithm.topics.doublepointer;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 *
 * @author marvin
 * @version LongestSubStringWithoutRepeatingCharacters.java, v 0.1 2022/05/21 19:06 Exp $
 */
public class LongestSubStringWithoutRepeatingCharacters {
    /**
     * 思路：滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList(
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "",
                "dvdf",
                "abba"
        );

        for (String s : list) {
            System.out.println(lengthOfLongestSubstring(s));
        }
    }
}

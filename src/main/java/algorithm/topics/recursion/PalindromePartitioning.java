package algorithm.topics.recursion;

import com.alibaba.fastjson.JSON;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 *
 * @author marvin
 * @version PalindromePartitioning.java, v 0.1 2022/10/05 20:15 Exp $
 */
public class PalindromePartitioning {
    /**
     * 方法一: 暴力破解
     * 1. 通过回溯找到所有子串
     * 2. 将是回文的子串加入到结果集中
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrace(s.toCharArray(), 0, new ArrayList<>(), ans);
        return ans;
    }


    private void backtrace(char[] s, int startIndex, List<String> path, List<List<String>> ans) {
        if (startIndex == s.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 开始枚举
        for (int i = startIndex; i < s.length; i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(new String(s, startIndex, i - startIndex + 1));
                backtrace(s, i + 1, path, ans);
                // 递归完成后,要将此串从集合中删除
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 判断字符串S的子串是否是回文字符串
     *
     * @param s     字符串 s
     * @param start 子串的起始位置
     * @param end   子串的结束位置
     * @return bool
     */
    private boolean isPalindrome(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
//        while (start <= end) {
//            if (s[start++] != s[end--]) {
//                return false;
//            }
//        }
        return true;
    }


    /**
     * 方法二：回溯+动态规划
     * 1. 通过动态规划加速判断所有回文子串
     * 2. 通过回溯算法找到所有子串
     * 3. 将回文子串加入到结果集
     *
     * @param s
     * @return
     */
    public List<List<String>> partition2(String s) {
        boolean[][] dp = buildPalindromeSubStringDpArray(s);
        List<List<String>> ans = new LinkedList<>();
        backtrace2(ans, new ArrayList<>(), s, 0, dp);
        return ans;
    }

    private void backtrace2(List<List<String>> ans, List<String> path, String s, int startIndex, boolean[][] dp) {
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (dp[startIndex][i]) {
                path.add(s.substring(startIndex, i + 1));
                backtrace2(ans, path, s, i + 1, dp);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 构建字符串S的所有回文子串dp数组
     *
     * @param s
     * @return
     */
    private boolean[][] buildPalindromeSubStringDpArray(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (j == i + 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = b & dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
//        List<List<String>> ans = palindromePartitioning.partition("aab");
        List<List<String>> ans = palindromePartitioning.partition2("aab");
        System.out.println(JSON.toJSONString(ans));

    }
}

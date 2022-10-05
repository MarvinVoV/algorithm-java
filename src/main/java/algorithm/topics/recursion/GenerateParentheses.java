package algorithm.topics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses>Generate Parentheses</a>
 *
 * @author marvin
 * @version GenerateParentheses.java, v 0.1 2022/10/04 06:40 Exp $
 */
public class GenerateParentheses {
    /**
     * 自顶向下回溯
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        backtrace("", n, n, ans);
        return ans;
    }

    /**
     * 自低向上递归
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    private void generate(List<String> ans, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            ans.add(str);
            return;
        }
        // 左括号数量不大于n, 可以放一个左括号
        if (open < max) {
            generate(ans, str + "(", open + 1, close, max);
        }
        // 右括号数量小于左括号数量，可以放一个右括号数量
        if (close < open) {
            generate(ans, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
//        List<String> result = generateParentheses.generateParenthesis(3);
        List<String> result = generateParentheses.generateParenthesis2(3);
        result.forEach(System.out::println);
    }

    private void backtrace(String str, int open, int close, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(str);
            return;
        }
        if (open == close) {
            // 剩余左右括号数相等，继续回溯只能用左括号
            backtrace(str + "(", open - 1, close, ans);
        } else if (open < close) {
            // 剩余左括号数小于右括号，继续回溯可以用左括号 也可以用右括号
            if (open > 0) {
                backtrace(str + "(", open - 1, close, ans);
            }
            backtrace(str + ")", open, close - 1, ans);
        }
    }
}

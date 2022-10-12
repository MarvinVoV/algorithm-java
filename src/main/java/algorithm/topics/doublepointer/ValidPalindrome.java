
package algorithm.topics.doublepointer;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">Valid Palindrome</a>
 *
 * @author hufeng
 * @version $Id: ValidPalindrome.java, v 0.1 2018年07月03日 下午1:36 hufeng Exp $
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(a)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(b)) {
                j--;
                continue;
            }
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
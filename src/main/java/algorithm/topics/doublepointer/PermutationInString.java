package algorithm.topics.doublepointer;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/">Permutation In String</a>
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * @author marvin
 * @version PermutationInString.java, v 0.1 2022/05/22 21:44 Exp $
 */
public class PermutationInString {
    /**
     * 思路: 滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int len1 = s1.length();
        int len2 = s2.length();

        // 总欠账表: s1的词频表
        int[] charCount = new int[26];
        for (char c : str1) {
            charCount[c - 'a']++;
        }
        // 滑动窗口的左右边界
        int l = 0, r = 0;
        // 依次尝试固定以s2中的每一个位置l作为左端点开始的len1长度的子串s2[l ... l+len1)是否是s1的排列
        // 固定左端点只需要尝试到len2-len1即可
        while (l <= len2 - len1) {
            // 右边界s2[r]字符进入窗口【还账】
            while (r < l + len1 && charCount[str2[r] - 'a'] >= 1) {
                // 还账
                charCount[str2[r] -'a']--;
                r++;
            }
            if (r == l + len1) {
                return true;
            }
            // 左边界s2[l]字符出窗口【赊账】，l++，开始尝试固定下一个位置做左端点
            charCount[str2[l] - 'a']++;
            l++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
//        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }
}

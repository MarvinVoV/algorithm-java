package algorithm.topics.doublepointer;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III</a>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * @author marvin
 * @version ReverseWords.java, v 0.1 2022/05/21 17:29 Exp $
 */
public class ReverseWords {
    /**
     * 翻转字符串
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        String[] reverseArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            // 双指针翻转
            char[] chars = item.toCharArray();
            int len = chars.length;
            for (int j = 0; j < len / 2; j++) {
                char tmp = chars[j];
                chars[j] = chars[len - 1 - j];
                chars[len - 1 - j] = tmp;
            }
            reverseArr[i] = new String(chars);
        }
        return String.join(" ", reverseArr);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));

    }
}

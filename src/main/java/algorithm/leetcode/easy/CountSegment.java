package algorithm.leetcode.easy;

public class CountSegment {
    /**
     * 遇到字符，判断前一个是不是空格，如果是空格，则为一个字符结束，累加1；
     * 遇到空格，记录当前是空格
     *
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        boolean isChar = false;
        for (char c : chars) {
            if (c != ' ') {
                if (!isChar) {
                    count++;
                }
                isChar = true;
            } else {
                isChar = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}

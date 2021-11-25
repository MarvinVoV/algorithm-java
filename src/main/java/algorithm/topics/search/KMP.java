package algorithm.topics.search;

/**
 * @author hufeng
 * @version KMP.java, v 0.1 2021/11/25 12:12 Exp $
 */

public class KMP {
    private static int[] getNexts(String pattern) {
        char[] b = pattern.toCharArray();
        int m = b.length;
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static int kmp(String target, String pattern) {
        char[] a = target.toCharArray();
        int n = a.length;
        char[] b = pattern.toCharArray();
        int m = b.length;

        int[] next = getNexts(pattern);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String target = "aaaaa";
        String pattern = "bba";
        System.out.println(kmp(target, pattern));
    }
}

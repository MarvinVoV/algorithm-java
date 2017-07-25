package sun.algorithm.leetcode;

import org.junit.Test;

/**
 * 1. 动态规划求最长公共子序列 <code>printLcs</code>
 * 2. 递归求最长公共子序列
 * <p>
 * <p>
 * https://www.ics.uci.edu/~eppstein/161/960229.html
 * http://www.sanfoundry.com/java-program-longest-common-substring-algorithm/
 * Created by marvin on 2017/07/25.
 */

public class LongestCommonSubSequence {

    class Data {
        int[][] c;
        String[][] b;

        public Data(int[][] c, String[][] b) {
            this.c = c;
            this.b = b;
        }
    }

    /**
     * 计算LCS的长度
     *
     * @param x X 序列
     * @param y Y 序列
     * @return b[i, j] 保存了对应计算c[i,j]时选择的子问题最优解, c[i,j]保存了X和Y自底向上求解每一个子问题的长度
     */
    private Data lcsLength(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;

        // let b[1..m, 1..n] and c[0..m, 0..n] be new table.
        String[][] b = new String[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "↖";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "↑";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "←";
                }
            }
        }
        return new Data(c, b);
    }

    /**
     * 构造LCS，通过利用lcsLength返回的表b快速构造X,Y的LCS，只需要简单的从b[m,n]开始，按照箭头方向追踪下去。
     *
     * @param b    保存子问题最优解的表
     * @param x    X序列
     * @param xLen X序列长度
     * @param yLen Y序列长度
     */
    private void printLcs(String[][] b, char[] x, int xLen, int yLen) {
        int i = xLen;
        int j = yLen;
        if (i == 0 || j == 0)
            return;
        if (b[i][j].equals("↖")) {
            printLcs(b, x, i - 1, j - 1);
            System.out.print(x[i - 1]);
        } else if (b[i][j].equals("↑")) {
            printLcs(b, x, i - 1, j);
        } else {
            printLcs(b, x, i, j - 1);
        }
    }

    /**
     * 改进，对于LCS算法，可以去掉表b，只维护一个表c。对于每个c[i,j]项只依赖于表c中的其他三项：
     * c[i-1,j], c[i, j-1], c[i-1, j-1]。给定c[i,j]的值，可以在O(1)时间内判断出在计算c[i,j]
     * 时使用了这三项的那一项。
     *
     * @param c    保存了X和Y自底向上求解每一个子问题的长度
     * @param x    X 序列
     * @param xLen X序列长度
     * @param yLen Y序列长度
     */
    private void printLcs2(int[][] c, char[] x, int xLen, int yLen) {
        int i = xLen;
        int j = yLen;
        if (i == 0 || j == 0)
            return;
        if (c[i - 1][j] == c[i][j - 1] && c[i - 1][j] == c[i - 1][j - 1] && c[i - 1][j - 1] + 1 == c[i][j]) {
            printLcs2(c, x, i - 1, j - 1);
            System.out.print(x[i - 1]);
        } else if (c[i - 1][j] == c[i][j - 1]) {
            printLcs2(c, x, i - 1, j);
        } else if (c[i - 1][j] > c[i][j - 1]) {
            printLcs2(c, x, i - 1, j);
        } else {
            printLcs2(c, x, i, j - 1);
        }
    }

    /**
     * 递归求解
     * 0                           if i == 0 or j == 0
     * c[i,j] =     c[i-1, j-1] + 1             if i,j > 0 and x[i] = y[j]
     * max(c[i,j-1], c[i-1,j])     if i,j > 0 and x[i] != y[i]
     *
     * @param x
     * @param y
     * @param c c[i,j]表示Xi和Yi的lcs的长度
     * @param i
     * @param j
     */
    // todo Error
    private void recursionSolution(char[] x, char[] y, int[][] c, int i, int j) {
        if (i == 0 || j == 0) {
            c[i][j] = 0;
            return;
        }
        if (x[i - 1] == y[j - 1]) {
            recursionSolution(x, y, c, i - 1, j - 1);
            c[i][j] = c[i - 1][j - 1] + 1;
            System.out.println("---" + c[i][j] + "  i=" + i + "  j=" + j);
        } else {
            recursionSolution(x, y, c, i - 1, j);
            recursionSolution(x, y, c, i, j - 1);
            c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
//            System.out.println(c[i][j-1] + " " + c[i-1][j] + "  " + c[i][j]);
        }
    }


    @Test
    public void testLcs() {
        String x = "ABCBDAB";
        String y = "BDCABA";
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();

        Data data = lcs.lcsLength(x.toCharArray(), y.toCharArray());
        // print table b
//        for (int i = 0; i < data.b.length; i++) {
//            for (int j = 0; j < data.b[i].length; j++) {
//                System.out.print(data.b[i][j] + " ");
//            }
//            System.out.println();
//        }
        // print table c
        for (int i = 0; i < data.c.length; i++) {
            for (int j = 0; j < data.c[i].length; j++) {
                System.out.print(data.c[i][j] + " ");
            }
            System.out.println();
        }
        printLcs(data.b, x.toCharArray(), x.length(), y.length()); // BCBA
        System.out.println();
        printLcs2(data.c, x.toCharArray(), x.length(), y.length()); // BCBA
    }

    @Test
    public void testRecursionSolution() {
        String x = "ABCBDAB";
        String y = "BDCABA";
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        int[][] c = new int[x.length() + 1][y.length() + 1];
        lcs.recursionSolution(x.toCharArray(), y.toCharArray(), c, x.length(), y.length());

        // print table c
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
//        printLcs2(c, x.toCharArray(), x.length(), y.length());
    }
}

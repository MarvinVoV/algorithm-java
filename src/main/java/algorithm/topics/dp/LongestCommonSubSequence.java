package algorithm.topics.dp;

/**
 * 最长公共子序列问题 Longest common subsequence problem
 * <p>
 * 最优子结构: 令X[1...m]和Y[1...n]为两个序列，Z[1...k]为X和Y的任意LCS
 * 1. 如果 x[m] == y[n], 则 Z[k]=X[m]=Y[n]且Z[k-1]是X[m-1]和Y[n-1]的一个LCS
 * 2. 如果 x[m] != y[n], 则 Z[k] != X[m] 意味着Z是X[1...m-1]和Y的一个LCS
 * 3. 如果 x[m] != y[n], 则 Z[k] != Y[n] 意味着Z是Y[1...n-1]和X的一个LCS
 * <p>
 * 得出如下公式
 * <pre>
 *              0              ,            (i=0 or j=0)
 *     c[i,j] = c[i-1, j-1] + 1,            (i,j>0 & x[i]!=y[j])
 *              max(c[i,j-1], c[i-1,j]),    (i,j>0 & x[i] != y[j])
 * </pre>
 * <p>
 * https://www.ics.uci.edu/~eppstein/161/960229.html
 * Created by marvin on 2017/07/25.
 */

public class LongestCommonSubSequence {

    static class Data {
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
    public static Data lcsLength(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;

        // 存储对应计算c[i,j]时所选择的子问题的最优解
        String[][] b = new String[m + 1][n + 1];
        // 存储X[1...i]和Y[1...j]的LCS的长度
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
    public static void printLcs(String[][] b, char[] x, int xLen, int yLen) {
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
    public static void printLcs2(int[][] c, char[] x, int xLen, int yLen) {
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
     * 递归求解最长公共子序列的长度; 二维数组中，长度最大的为最优解的长度;
     * 在递归求解中，会重复求解子问题
     * <pre>
     *              0                           if i == 0 or j == 0
     * c[i,j] =     c[i-1, j-1] + 1             if i,j > 0 and x[i] = y[j]
     *              max(c[i,j-1], c[i-1,j])     if i,j > 0 and x[i] != y[i]
     * </pre>
     *
     * @param x 序列X
     * @param y 序列Y
     * @param c c[i,j]表示Xi和Yi的lcs的长度
     * @param i 序列X的长度
     * @param j 序列Y的长度
     */
    public static void recursionSolutionLcs(char[] x, char[] y, int[][] c, int i, int j) {
        if (i == 0 || j == 0) {
            c[i][j] = 0;
            return;
        }
        if (x[i - 1] == y[j - 1]) {
            recursionSolutionLcs(x, y, c, i - 1, j - 1);
            c[i][j] = c[i - 1][j - 1] + 1;
        } else {
            recursionSolutionLcs(x, y, c, i - 1, j);
            recursionSolutionLcs(x, y, c, i, j - 1);
            c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
        }
    }

}

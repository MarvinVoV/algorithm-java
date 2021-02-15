package algorithm.topics.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestCommonSubSequenceTest {

    private static String x;
    private static String y;

    @BeforeEach
    public void init() {
        x = "ABCBDAB";
        y = "BDCABA";

    }

    @Test
    public void testLcs() {
        LongestCommonSubSequence.Data data = LongestCommonSubSequence.lcsLength(x.toCharArray(), y.toCharArray());
        // print table c
        printOptimalSolutionArray(data.c);

        LongestCommonSubSequence.printLcs(data.b, x.toCharArray(), x.length(), y.length()); // BCBA
        System.out.println();
        LongestCommonSubSequence.printLcs2(data.c, x.toCharArray(), x.length(), y.length()); // BCBA
        System.out.println();
    }

    @Test
    public void testRecursionSolutionLcs() {
        int[][] c = new int[x.length() + 1][y.length() + 1];
        LongestCommonSubSequence.recursionSolutionLcs(x.toCharArray(), y.toCharArray(), c, x.length(), y.length());
        printOptimalSolutionArray(c);
    }


    private void printOptimalSolutionArray(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

}
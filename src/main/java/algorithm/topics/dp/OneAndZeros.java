package algorithm.topics.dp;


/**
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/">One and Zeros</a>
 *
 * @author marvin
 * @version OneAndZeros.java, v 0.1 2022/10/06 23:38 Exp $
 */
public class OneAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            // m => 0
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];

    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    public static void main(String[] args) {
        OneAndZeros oneAndZeros = new OneAndZeros();
        String[] strs= new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5, n=3;
        int ans = oneAndZeros.findMaxForm(strs, m, n);
        System.out.println(ans);
    }

}

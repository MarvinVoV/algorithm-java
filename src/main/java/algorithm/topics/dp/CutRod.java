package algorithm.topics.dp;

import java.util.Arrays;

/**
 * 钢条切割问题： 给定一段长度为n英寸的钢条和一个价格表p[i] (i=1,2,..,n),求切割钢条方案，使得销售收益R[n]最大。
 * 注意：如果长度为n英寸的钢条的价格p[n]足够大，最优解可能就是完全不需要切割。
 *
 * @author hufeng
 * @version CutRod.java, v 0.1 2018/11/24 9:59 PM Exp $
 */

public class CutRod {
    /**
     * 自顶向下递归实现
     * 将钢条从左边切割下长度为i的一段，只对右边剩下的长度为n-i的一段继续进行切割（递归求解），对
     * 左侧一段则不再进行切割。即问题分解的方式为：将长度为n的钢条分解为左边开始的一段，以及剩余部分继续分解的结果。
     * 得到简化公式
     * R[i] = max(p[i]+r[n-1])
     * <p>
     * 时间复杂度 T(n)=Math.pow(2,n) 因为反复求解相同的子问题
     *
     * @param price 钢条价格表，长度为n英寸的钢条价格为p[n], n: 1-based
     * @param n     切割的目标钢条的长度， 1-based
     * @return 切割方案的最大收益
     */
    public static int cutRod(int[] price, int n) {
        if (n == 0)
            return 0;
        int q = -Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, price[i - 1] + cutRod(price, n - i));
        }
        return q;
    }

    /**
     * 动态规划求解-带备忘录的自顶向下法(Top-down with memoization)
     *
     * @param price 钢条价格表，长度为n英寸的钢条价格为p[n], n: 1-based
     * @param n     切割的目标钢条的长度， 1-based
     * @return 切割方案的最大收益
     */
    public static int memorizedCutRod(int[] price, int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return memorizedCutRodAux(price, n, cache);
    }

    private static int memorizedCutRodAux(int[] price, int n, int[] cache) {
        if (n > 0 && cache[n - 1] >= 0) {
            return cache[n - 1];
        }

        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = -Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, price[i - 1] + memorizedCutRodAux(price, n - i, cache));
            }
        }
        if (n > 0) {
            cache[n - 1] = q;
        }
        return q;
    }

    /**
     * 动态规划求解-自底向上法(Bottom-up method)
     * 自底向上采用自问题的自然顺序： 若i<j, 则规模为i的子问题比规模为j的子问题更小。
     *
     * @param price 钢条价格表，长度为n英寸的钢条价格为p[n], n: 1-based
     * @param n     切割的目标钢条的长度， 1-based
     * @return 切割方案的最大收益
     */
    public static int bottomUpCutRod(int[] price, int n) {
        // 用来保存子问题的解 1-based
        int[] r = new int[n + 1];
        // 长度为0的钢条没有收益
        Arrays.fill(r, 0);

        // 求解规模为j的子问题
        for (int j = 1; j <= n; j++) {
            int q = -Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, price[i - 1] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];
    }

}

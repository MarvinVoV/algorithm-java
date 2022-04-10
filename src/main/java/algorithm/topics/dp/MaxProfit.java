package algorithm.topics.dp;

/**
 * 买卖股票最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    /**
     * 暴力破解
     *
     * @param prices
     * @return
     */
    public static int maxProfitByBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitByDp(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitByDp(prices));
        System.out.println(maxProfitByBruteForce(prices));
    }
}

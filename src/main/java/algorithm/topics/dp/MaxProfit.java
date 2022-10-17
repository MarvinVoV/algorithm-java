package algorithm.topics.dp;

/**
 * 买卖股票最佳时机
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">Best Time to Buy And Sell Stock</a>
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

    /**
     * 一次循环，找最低点和最高点的差
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;

    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitByBruteForce(prices));
    }
}

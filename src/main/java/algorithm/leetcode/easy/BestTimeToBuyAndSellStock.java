package algorithm.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">Best Time to Buy and Sell Stock</a>
 *
 * @author hufeng
 * @version $Id: BestTimeToBuyAndSellStock.java, v 0.1 2018年07月04日 下午3:58 hufeng Exp $
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
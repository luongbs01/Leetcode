/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length, ans = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] < prices[i]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}

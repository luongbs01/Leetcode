/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */

public class BestTimeToBuyAndSellStockWithCooldown {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		// dp[i]: max profit from day 0 to day i
		// dp[i] = max(dp[i-1], dp[j-2] + prices[i] - price[j])   j=0->i
		// either (dp[i-1] -> no transaction on day i) or (dp[j-2] + prices[i] - price[j] -> cooldown on day j-1, buy on day j, sell on day i)
		int[] dp = new int[n];
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], prices[i] - min);
			min = Math.min(min, prices[i] -  (i > 1 ? dp[i - 2] : 0));
		}
		return dp[n - 1];
	}
}

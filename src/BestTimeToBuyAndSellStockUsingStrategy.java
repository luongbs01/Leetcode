/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/description/
 */

public class BestTimeToBuyAndSellStockUsingStrategy {

	public long maxProfit(int[] prices, int[] strategy, int k) {
		int n = prices.length;
		long[] prefixSum = new long[n];
		prefixSum[0] = (long) prices[0] * strategy[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + (long) prices[i] * strategy[i];
		}
		long ans = prefixSum[n - 1], sum = 0;
		for (int i = k / 2; i < k; i++) {
			sum += prices[i];
		}
		for (int i = 0; i <= n - k; i++) {
			ans = Math.max(ans, prefixSum[n - 1] - prefixSum[i + k - 1] + (i > 0 ? prefixSum[i - 1] : 0) + sum);
			if (i < n - k)
				sum = sum + prices[i + k] - prices[i + k / 2];
		}
		return ans;
	}
}

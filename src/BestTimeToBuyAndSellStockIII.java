/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n]; //dp1[i]: max profit from day 0 to day i
        int[] dp2 = new int[n]; //dp2[i]: max profit from day i to day n-1
        int min = prices[0], max = prices[n - 1];
        for (int i = 1; i < n; i++) {
            // either (dp[i-1] -> no transaction on day i) or (prices[i] - min -> sell on day i)
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int ans = Math.max(0, dp1[n - 1]);
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, dp1[i - 1] + dp2[i]);
        }
        return ans;
    }
}

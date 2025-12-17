/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/
 */

public class BestTimeToBuyAndSellStockV {

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        // dp[i][j]: max profit from day 0 to day j with at most i transactions
        // dp[i][j] = max(dp[i][j-1], max(price[j]-price[k]+dp[i-1][k-1],-price[j]+price[k]+dp[i-1][k-1]))   (k= 1-> j)
        // either (dp[i][j-1] -> no transaction on day j) or (either price[j]-(price[k]-dp[i-1][k-1]) or -price[j]+price[k]+dp[i-1][k-1] -> sell/buy on day j)
        long[][] dp = new long[k + 1][n];
        for (int i = 1; i <= k; i++) {
            long min = prices[0];
            long max = prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(prices[j] - min, max - prices[j]));
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
                max = Math.max(max, prices[j] + dp[i - 1][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}

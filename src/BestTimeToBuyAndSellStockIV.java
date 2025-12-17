/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 */

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // dp[i][j]: max profit from day 0 to day j with at most i transactions
        // dp[i][j] = max(dp[i][j-1], price[j]-price[k]+dp[i-1][k-1])   (k= 1-> j)
        // either (dp[i][j-1] -> no transaction on day j) or (price[j]-(price[k]-dp[i-1][k-1]) -> sell on day j)
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}

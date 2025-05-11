/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length]; // min price from day 0 till day i
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            dp[i] = Math.min(prices[i], min);
            min = Math.min(min, dp[i]);
            ans = Math.max(ans, prices[i] - dp[i]);
        }
        return ans;
    }

    public int maxProfitV2(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;
    }
}

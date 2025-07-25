/**
 * Description: https://leetcode.com/problems/coin-change-ii/
 */

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j]: number of combinations that make up that amount of i using first j coins
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}

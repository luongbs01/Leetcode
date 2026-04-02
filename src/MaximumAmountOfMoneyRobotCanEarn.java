/**
 * Description: https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/description/
 */

public class MaximumAmountOfMoneyRobotCanEarn {

	public int maximumAmount(int[][] coins) {
		int m = coins.length, n = coins[0].length;
		int[][][] dp = new int[3][m][n];
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (i == 0 && j == 0) {
						dp[k][i][j] = coins[i][j];
					} else if (i == 0) {
						dp[k][i][j] = dp[k][i][j - 1] + coins[i][j];
					} else if (j == 0) {
						dp[k][i][j] = dp[k][i - 1][j] + coins[i][j];
					} else {
						dp[k][i][j] = Math.max(dp[k][i - 1][j], dp[k][i][j - 1]) + coins[i][j];
					}

					if (k > 0 && coins[i][j] < 0) {
						if (i == 0 && j == 0) {
							dp[k][i][j] = Math.max(dp[k][i][j], 0);
						} else if (i == 0) {
							dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i][j - 1]);
						} else if (j == 0) {
							dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - 1][j]);
						} else {
							dp[k][i][j] = Math.max(dp[k][i][j], Math.max(dp[k - 1][i - 1][j], dp[k - 1][i][j - 1]));
						}
					}
				}
			}
		}
		return dp[2][m - 1][n - 1];
	}
}

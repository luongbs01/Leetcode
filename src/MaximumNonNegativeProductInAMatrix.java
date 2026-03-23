/**
 * Description: https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/
 */

public class MaximumNonNegativeProductInAMatrix {

	public int maxProductPath(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		long[][][] dp = new long[m][n][2];
		boolean hasZero = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j][0] = -1;
				hasZero |= (grid[i][j] == 0);
			}
		}
		if (grid[0][0] >= 0) {
			dp[0][0][0] = grid[0][0];
		} else {
			dp[0][0][1] = grid[0][0];
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] >= 0) {
					if (i > 0) {
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] * grid[i][j]);
						dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][1] * grid[i][j]);
					}
					if (j > 0) {
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][0] * grid[i][j]);
						dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][1] * grid[i][j]);
					}
				} else {
					if (i > 0) {
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][1] * grid[i][j]);
						dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][0] * grid[i][j]);
					}
					if (j > 0) {
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][1] * grid[i][j]);
						dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][0] * grid[i][j]);
					}
				}
			}
		}
		return dp[m - 1][n - 1][0] > 0 ? (int) (dp[m - 1][n - 1][0] % 1_000_000_007) :
			(hasZero ? 0 : -1);
	}
}

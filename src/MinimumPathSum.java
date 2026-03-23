import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-path-sum/
 */

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = grid[0][0];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
				}
				if (j > 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}

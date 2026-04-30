import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-path-score-in-a-grid/description/
 */

public class MaximumPathScoreInAGrid {

	public int maxPathScore(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		k = Math.min(m + n - 2, k);
		int[][][] dp = new int[m][n][k + 1];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				Arrays.fill(dp[r][c], -1);
			}
		}
		for (int i = 0; i <= k; i++) {
			dp[0][0][i] = 0;
		}
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (r + c == 0) {
					continue;
				}
				int cost = (grid[r][c] + 1) >> 1;
				for (int i = cost; i <= k; i++) {
					int max = Math.max(r > 0 ? dp[r - 1][c][i - cost] : -1, c > 0 ? dp[r][c - 1][i - cost] : -1);
					dp[r][c][i] = max == -1 ? -1 : max + grid[r][c];
				}
			}
		}
		return dp[m - 1][n - 1][k];
	}
}

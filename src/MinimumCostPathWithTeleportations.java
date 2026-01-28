import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/minimum-cost-path-with-teleportations/
 */

public class MinimumCostPathWithTeleportations {

	public int minCost(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int[][][] dp = new int[k + 1][m][n];

		// base case: no teleport
		for (int i = 1; i < n; i++) {
			dp[0][0][i] = dp[0][0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			dp[0][i][0] = dp[0][i - 1][0] + grid[i][0];
			for (int j = 1; j < n; j++) {
				dp[0][i][j] = Math.min(dp[0][i - 1][j], dp[0][i][j - 1]) + grid[i][j];
			}
		}

		int[][] cost = new int[m * n][3];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cost[i * n + j] = new int[] { i, j, grid[i][j] };
			}
		}
		Arrays.sort(cost, Comparator.comparingInt(o -> o[2]));

		// teleport i times
		for (int i = 1; i <= k; i++) {
			// suffix min
			// minCost[i]: minimum cost to teleport from any cell (x, y) such that grid[x][y] >= i
			int[] minCost = new int[10001];
			Arrays.fill(minCost, Integer.MAX_VALUE);
			int min = dp[i - 1][cost[m * n - 1][0]][cost[m * n - 1][1]];
			for (int j = cost.length - 1; j >= 0; j--) {
				minCost[cost[j][2]] = Math.min(min, dp[i - 1][cost[j][0]][cost[j][1]]);
				min = Math.min(min, minCost[cost[j][2]]);
			}

			for (int j = 1; j < n; j++) {
				dp[i][0][j] = Math.min(dp[i][0][j - 1] + grid[0][j], minCost[grid[0][j]]);
			}
			for (int j = 1; j < m; j++) {
				dp[i][j][0] = Math.min(dp[i][j - 1][0] + grid[j][0], minCost[grid[j][0]]);
				for (int l = 1; l < n; l++) {
					dp[i][j][l] = Math.min(
						Math.min(dp[i][j - 1][l], dp[i][j][l - 1]) + grid[j][l], // no teleport
						minCost[grid[j][l]] // teleport
					);
				}
			}
		}

		// min cost: can be teleported any number of times
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i++) {
			ans = Math.min(ans, dp[i][m - 1][n - 1]);
		}
		return ans;
	}
}

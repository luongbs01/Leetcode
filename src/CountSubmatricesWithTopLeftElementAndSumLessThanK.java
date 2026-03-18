/**
 * Description: https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
 */

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {

	public int countSubmatrices(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int ans = grid[0][0] <= k ? 1 : 0;
		for (int i = 1; i < n; i++) {
			grid[0][i] = grid[0][i - 1] + grid[0][i];
			if (grid[0][i] <= k) {
				ans++;
			}
		}
		for (int i = 1; i < m; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
			if (grid[i][0] <= k) {
				ans++;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1] + grid[i][j];
				if (grid[i][j] <= k) {
					ans++;
				} else {
					break;
				}
			}
		}
		return ans;
	}
}

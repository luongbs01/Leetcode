/**
 * Description: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/
 */

public class CountSubmatricesWithEqualFrequencyOfXAndY {

	public int numberOfSubmatrices(char[][] grid) {
		int m = grid.length, n = grid[0].length, ans = 0;
		int[][] mat = new int[m][n];
		boolean[][] hasOne = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = grid[i][j] == 'X' ? 1 : grid[i][j] == 'Y' ? -1 : 0;
			}
		}
		hasOne[0][0] = mat[0][0] == 1;
		for (int i = 1; i < m; i++) {
			hasOne[i][0] = mat[i][0] == 1 || hasOne[i - 1][0];
			mat[i][0] += mat[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			hasOne[0][i] = mat[0][i] == 1 || hasOne[0][i - 1];
			mat[0][i] += mat[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				hasOne[i][j] = mat[i][j] == 1 || hasOne[i - 1][j] || hasOne[i][j - 1];
				mat[i][j] = mat[i][j] + mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0 && hasOne[i][j]) {
					ans++;
				}
			}
		}
		return ans;
	}
}

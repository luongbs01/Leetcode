/**
 * Description: https://leetcode.com/problems/construct-product-matrix/description/
 */

public class ConstructProductMatrix {

	// 26ms
	public int[][] constructProductMatrix(int[][] grid) {
		int m = grid.length, n = grid[0].length, mod = 12345;
		int[][] ans = new int[m][n];
		long[][] leftPrefix = new long[m][n], rightPrefix = new long[m][n];
		long[] topPrefix = new long[m], botPrefix = new long[m];
		for (int i = 0; i < m; i++) {
			topPrefix[i] = i > 0 ? (topPrefix[i - 1] * grid[i][0]) % mod : grid[i][0];
			leftPrefix[i][0] = grid[i][0];
			rightPrefix[i][n - 1] = grid[i][n - 1];
			for (int j = 1; j < n; j++) {
				leftPrefix[i][j] = (leftPrefix[i][j - 1] * grid[i][j]) % mod;
				rightPrefix[i][n - 1 - j] = (rightPrefix[i][n - j] * grid[i][n - j - 1]) % mod;
				topPrefix[i] = (topPrefix[i] * grid[i][j]) % mod;
			}
		}
		for (int i = m - 1; i >= 0; i--) {
			botPrefix[i] = i < m - 1 ? (botPrefix[i + 1] * grid[i][0]) % mod : grid[i][0];
			for (int j = 1; j < n; j++) {
				botPrefix[i] = (botPrefix[i] * grid[i][j]) % mod;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				long p = 1;
				if (i > 0) p *= topPrefix[i - 1];
				if (i + 1 < m) p *= botPrefix[i + 1];
				if (j > 0) p *= leftPrefix[i][j - 1];
				if (j + 1 < n) p *= rightPrefix[i][j + 1];
				ans[i][j] = (int) (p % mod);
			}
		}
		return ans;
	}

	// 11ms
	public int[][] constructProductMatrixV2(int[][] grid) {
		int m = grid.length, n = grid[0].length, index = 0, mod = 12_345;
		int[][] ans = new int[m][n];
		long[] prefix = new long[m * n + 1];
		long[] suffix = new long[m * n + 1];
		prefix[0] = 1;
		suffix[m * n] = 1;
		for (int[] row : grid) {
			for (int j = 0; j < n; j++) {
				prefix[index + 1] = (prefix[index] * row[j]) % mod;
				index++;
			}
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				suffix[index - 1] = (suffix[index] * grid[i][j]) % mod;
				index--;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = (int) ((prefix[index] * suffix[index + 1]) % mod);
				index++;
			}
		}
		return ans;
	}
}

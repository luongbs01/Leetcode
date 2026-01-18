/**
 * Description: https://leetcode.com/problems/largest-magic-square/
 */

public class LargestMagicSquare {

	public int largestMagicSquare(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int ans = Math.min(m, n);
		while (!foundMagicSquare(grid, m, n, ans)) {
			ans--;
		}
		return ans;
	}

	private boolean foundMagicSquare(int[][] grid, int m, int n, int size) {
		boolean found = false;
		for (int i = 0; i <= m - size; i++) {
			for (int j = 0; j <= n - size; j++) {
				if (check(grid, i, j, size)) {
					found = true;
					break;
				}
			}
		}
		return found;
	}

	private boolean check(int[][] grid, int m, int n, int size) {
		int sum = 0, sum2;
		for (int i = m; i < m + size; i++) {
			sum += grid[i][n];
		}

		// row sum
		for (int i = m; i < m + size; i++) {
			sum2 = 0;
			for (int j = n; j < n + size; j++) {
				sum2 += grid[i][j];
			}
			if (sum2 != sum)
				return false;
		}

		// column sum
		for (int i = n; i < n + size; i++) {
			sum2 = 0;
			for (int j = m; j < m + size; j++) {
				sum2 += grid[j][i];
			}
			if (sum2 != sum)
				return false;
		}

		// diagonal sum
		sum2 = 0;
		for (int i = 0; i < size; i++) {
			sum2 += grid[m + i][n + i];
		}
		if (sum2 != sum)
			return false;

		sum2 = 0;
		for (int i = 0; i < size; i++) {
			sum2 += grid[m + i][n + size - 1 - i];
		}
		if (sum2 != sum)
			return false;

		return true;
	}
}

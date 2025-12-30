/**
 * Description: https://leetcode.com/problems/magic-squares-in-grid/
 */

public class MagicSquaresInGrid {

	public int numMagicSquaresInside(int[][] grid) {
		int m = grid.length, n = grid[0].length, ans = 0;
		for (int i = 0; i < m - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15
					|| grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15
					|| grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15
					|| grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15
					|| grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15
					|| grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15
					|| grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15
					|| grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15)
					continue;
				boolean[] marked = new boolean[16];
				marked[grid[i][j]] = true;
				marked[grid[i][j + 1]] = true;
				marked[grid[i][j + 2]] = true;
				marked[grid[i + 1][j]] = true;
				marked[grid[i + 1][j + 1]] = true;
				marked[grid[i + 1][j + 2]] = true;
				marked[grid[i + 2][j]] = true;
				marked[grid[i + 2][j + 1]] = true;
				marked[grid[i + 2][j + 2]] = true;
				boolean valid = true;
				for (int k = 1; k < 10; k++) {
					if (!marked[k]) {
						valid = false;
						break;
					}
				}
				if (!valid)
					continue;
				ans++;
			}
		}
		return ans;
	}
}

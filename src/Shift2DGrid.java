import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/shift-2d-grid/
 */

public class Shift2DGrid {

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int[][] newGrid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int newI = (i + (k + j) / n) % m;
				int newJ = (j + k) % n;
				newGrid[newI][newJ] = grid[i][j];
			}
		}
		List<List<Integer>> ans = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			List<Integer> row = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				row.add(newGrid[i][j]);
			}
			ans.add(row);
		}
		return ans;
	}
}

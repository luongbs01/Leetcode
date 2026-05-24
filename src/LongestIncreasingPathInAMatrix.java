/**
 * Description: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */


// dfs + memoization
public class LongestIncreasingPathInAMatrix {

	int[][] longestPath;
	int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, ans = 1;
		longestPath = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				longestPath[i][j] = dfs(matrix, m, n, i, j);
			}
		}
		for (int[] row : longestPath) {
			for (int cell : row) {
				ans = Math.max(ans, cell);
			}
		}
		return ans;
	}

	// calculate longest increasing path from [startingRow, startingCol]
	private int dfs(int[][] matrix, int m, int n, int startingRow, int startingCol) {
		if (longestPath[startingRow][startingCol] > 0) {
			return longestPath[startingRow][startingCol];
		}
		int max = 1;
		for (int[] direction : directions) {
			int nextRow = startingRow + direction[0];
			int nextCol = startingCol + direction[1];
			if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
				&& matrix[nextRow][nextCol] > matrix[startingRow][startingCol]) {
				max = Math.max(max, dfs(matrix, m, n, nextRow, nextCol) + 1);
			}
		}
		longestPath[startingRow][startingCol] = max;
		return max;
	}
}

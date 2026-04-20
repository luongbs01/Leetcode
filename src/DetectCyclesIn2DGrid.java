import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */

public class DetectCyclesIn2DGrid {

	public boolean containsCycle(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];
		ArrayDeque<int[][]> stack;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					stack = new ArrayDeque<>();
					stack.add(new int[][] { { -1, -1 }, { i, j } });
					while (!stack.isEmpty()) {
						int[][] top = stack.pop();
						int prevX = top[0][0], prevY = top[0][1], currX = top[1][0], currY = top[1][1];
						visited[currX][currY] = true;
						for (int[] direction : directions) {
							int nextX = currX + direction[0];
							int nextY = currY + direction[1];
							if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
								&& grid[nextX][nextY] == grid[currX][currY] && !(nextX == prevX && nextY == prevY)) {
								if (visited[nextX][nextY]) {
									return true;
								} else {
									stack.add(new int[][] { { currX, currY }, { nextX, nextY } });
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}

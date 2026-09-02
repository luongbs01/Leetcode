import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */

public class ShortestPathInAGridWithObstaclesElimination {

	public int shortestPath(int[][] grid, int k) {
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int m = grid.length, n = grid[0].length;
		// [0]: 1, [1]: y, [2]: number of obstacles that can eliminate, [3]: number of steps
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0, k, 0 });
		boolean[][][] visited = new boolean[m][n][k + 1];

		while (!queue.isEmpty()) {
			int[] head = queue.poll();
			int x = head[0], y = head[1], elimination = head[2], steps = head[3];
			if (x == m - 1 && y == n - 1) {
				return steps;
			}

			if (!visited[x][y][elimination]) {
				visited[x][y][elimination] = true;
				for (int[] direction : directions) {
					int nextX = x + direction[0], nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
						int nextElimination = elimination;
						if (grid[nextX][nextY] == 1) {
							nextElimination -= 1;
						}

						if (nextElimination < 0) {
							continue;
						}

						if (!visited[nextX][nextY][nextElimination]) {
							queue.offer(new int[] { nextX, nextY, nextElimination, steps + 1 });
						}
					}
				}
			}
		}

		return -1;
	}
}

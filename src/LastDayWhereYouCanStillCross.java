import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/last-day-where-you-can-still-cross/
 */

public class LastDayWhereYouCanStillCross {

	int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int latestDayToCross(int row, int col, int[][] cells) {
		int l = 0, r = row * col;
		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (canCross(row, col, cells, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	private boolean canCross(int row, int col, int[][] cells, int lastDay) {
		boolean[][] grid = new boolean[row][col];
		for (int i = 0; i < lastDay; i++) {
			grid[cells[i][0] - 1][cells[i][1] - 1] = true;
		}
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < col; i++) {
			if (!grid[0][i]) {
				queue.offer(new int[] { 0, i });
				grid[0][i] = true;
			}
		}
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int[] direction : directions) {
				int nextX = curr[0] + direction[0];
				int nextY = curr[1] + direction[1];
				if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
					&& !grid[nextX][nextY]) {
					if (nextX == row - 1) {
						return true;
					}
					queue.offer(new int[] { nextX, nextY });
					grid[nextX][nextY] = true;
				}
			}
		}
		return false;
	}
}

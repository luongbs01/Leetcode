import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/last-day-where-you-can-still-cross/
 */

public class LastDayWhereYouCanStillCross {

	// Binary Search + BFS
	class Solution1 {
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

	// Disjoint Set Union
	class Solution2 {
		int[] rank, size;

		public int latestDayToCross(int row, int col, int[][] cells) {
			int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
			boolean[][] grid = new boolean[row][col];
			int n = cells.length;
			rank = new int[n + 2];
			size = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				rank[i] = i;
				size[i] = 1;
			}
			for (int i = 0; i < n; i++) {
				int currX = cells[i][0] - 1;
				int currY = cells[i][1] - 1;
				grid[currX][currY] = true;
				int currIndex = currX * col + currY + 1;
				for (int[] direction : directions) {
					int nextX = currX + direction[0];
					int nextY = currY + direction[1];
					if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY]) {
						int nextIndex = nextX * col + nextY + 1;
						union(currIndex, nextIndex);
					}
				}
				if (currY == 0) {
					union(0, currIndex);
				}
				if (currY == col - 1) {
					union(n + 1, currIndex);
				}
				if (find(0) == find(n + 1)) {
					return i;
				}
			}
			return n;
		}

		private int find(int i) {
			if (rank[i] == i) {
				return i;
			}
			int parent = find(rank[i]);
			rank[i] = parent;
			return parent;
		}

		private void union(int i, int j) {
			int pi = find(i);
			int pj = find(j);
			if (pi != pj) {
				if (size[pi] < size[pj]) {
					int temp = pi;
					pi = pj;
					pj = temp;
				}

				rank[pj] = pi;
				size[pi] += size[pj];
			}
		}
	}

}

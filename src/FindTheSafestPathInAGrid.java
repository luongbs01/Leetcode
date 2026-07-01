import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-the-safest-path-in-a-grid/
 */

public class FindTheSafestPathInAGrid {

	int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int maximumSafenessFactor(List<List<Integer>> grid) {
		int m = grid.size(), n = grid.getFirst().size();
		int[][] dist = new int[m][n];
		boolean[] visited = new boolean[m * n];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid.get(i).get(j) == 1) {
					pq.offer(new int[] { 0, i, j });
				}
			}
		}
		while (!pq.isEmpty()) {
			int[] head = pq.poll();
			int x = head[1], y = head[2];
			if (!visited[x * n + y]) {
				visited[x * n + y] = true;
				dist[x][y] = head[0];
				for (int[] direction : directions) {
					int nextX = x + direction[0];
					int nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX * n + nextY]) {
						pq.offer(new int[] { head[0] + 1, nextX, nextY });
					}
				}
			}
		}

		int l = 0, r = m + n;
		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (valid(m, n, dist, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	private boolean valid(int m, int n, int[][] dist, int minDist) {
		boolean[] visited = new boolean[m * n];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		if (dist[0][0] >= minDist) {
			queue.offer(new int[] { 0, 0 });
		}
		while (!queue.isEmpty()) {
			int[] head = queue.poll();
			int x = head[0], y = head[1];
			if (!visited[x * n + y]) {
				visited[x * n + y] = true;
				if (x == m - 1 && y == n - 1) {
					return true;
				}
				for (int[] direction : directions) {
					int nextX = x + direction[0];
					int nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
						&& !visited[nextX * n + nextY] && dist[nextX][nextY] >= minDist) {
						queue.offer(new int[] { nextX, nextY });
					}
				}
			}
		}
		return false;
	}
}

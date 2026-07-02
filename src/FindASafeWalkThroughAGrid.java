import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
 */

public class FindASafeWalkThroughAGrid {

	public boolean findSafeWalk(List<List<Integer>> grid, int health) {
		int m = grid.size(), n = grid.getFirst().size();
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[] visited = new boolean[m * n];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		pq.offer(new int[] { grid.getFirst().getFirst(), 0, 0 });
		while (!pq.isEmpty()) {
			int[] head = pq.poll();
			int x = head[1], y = head[2];
			if (!visited[n * x + y]) {
				visited[n * x + y] = true;
				if (x == m - 1 && y == n - 1) {
					return head[0] < health;
				}
				for (int[] direction : directions) {
					int nextX = x + direction[0];
					int nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
						&& !visited[n * nextX + nextY]) {
						pq.offer(new int[] { head[0] + grid.get(nextX).get(nextY), nextX, nextY });
					}
				}
			}
		}
		return false;
	}
}

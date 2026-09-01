import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-to-get-all-keys/
 */

public class ShortestPathToGetAllKeys {

	public int shortestPathAllKeys(String[] grid) {
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int m = grid.length, n = grid[0].length(), cnt = 0, sx = 0, sy = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (Character.isLowerCase(grid[i].charAt(j))) {
					map.put(grid[i].charAt(j), 1 << cnt);
					cnt++;
				} else if (grid[i].charAt(j) == '@') {
					sx = i;
					sy = j;
				}
			}
		}

		if (cnt == 0) {
			return 0;
		}

		boolean[][][] visited = new boolean[m][n][1 << cnt];
		Queue<int[]> queue = new ArrayDeque<>(); // [0]: x, [1]: y, [2]: bitmask, [3]: number of moves
		queue.offer(new int[] { sx, sy, 0, 0 });
		while (!queue.isEmpty()) {
			int[] head = queue.poll();
			int x = head[0], y = head[1], bitmask = head[2], moves = head[3];
			if (!visited[x][y][bitmask]) {
				visited[x][y][bitmask] = true;
				for (int[] direction : directions) {
					int nextX = x + direction[0], nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
						&& grid[nextX].charAt(nextY) != '#') {
						int nextMask = bitmask;
						if (Character.isLowerCase(grid[nextX].charAt(nextY))) {
							nextMask = bitmask | map.get(grid[nextX].charAt(nextY));
						} else if (Character.isUpperCase(grid[nextX].charAt(nextY))) {
							boolean hasKey = (bitmask & map.get(Character.toLowerCase(grid[nextX].charAt(nextY)))) != 0;
							if (!hasKey) {
								continue;
							}
						}

						if (nextMask == (1 << cnt) - 1) {
							return moves + 1;
						}

						if (!visited[nextX][nextY][nextMask]) {
							queue.offer(new int[] { nextX, nextY, nextMask, moves + 1 });
						}
					}
				}
			}
		}

		return -1;
	}
}

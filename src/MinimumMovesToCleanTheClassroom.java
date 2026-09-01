import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
 */

public class MinimumMovesToCleanTheClassroom {

	public int minMoves(String[] classroom, int energy) {
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int m = classroom.length, n = classroom[0].length(), cnt = 0, sx = 0, sy = 0;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (classroom[i].charAt(j) == 'L') {
					arr[i][j] = 1 << cnt;
					cnt++;
				} else if (classroom[i].charAt(j) == 'S') {
					sx = i;
					sy = j;
				}
			}
		}

		if (cnt == 0) {
			return 0;
		}

		int[][][] maxEnergy = new int[m][n][1 << cnt];
		Queue<State> queue = new ArrayDeque<>();
		queue.offer(new State(sx, sy, 0, energy, 0));
		while (!queue.isEmpty()) {
			State head = queue.poll();
			int x = head.x, y = head.y, visited = head.visited, currEnergy = head.energy, steps = head.steps;

			if (currEnergy > maxEnergy[x][y][visited]) {
				maxEnergy[x][y][visited] = currEnergy;
				for (int[] direction : directions) {
					int nextX = x + direction[0], nextY = y + direction[1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
						&& classroom[nextX].charAt(nextY) != 'X') {
						int nextEnergy = currEnergy - 1;
						int nextVisited = visited;
						if (classroom[nextX].charAt(nextY) == 'R') {
							nextEnergy = energy;
						} else if (classroom[nextX].charAt(nextY) == 'L') {
							nextVisited = visited | arr[nextX][nextY];
						}

						if (nextVisited == (1 << cnt) - 1) {
							return steps + 1;
						}

						if (nextEnergy > maxEnergy[nextX][nextY][nextVisited]) {
							queue.offer(new State(nextX, nextY, nextVisited, nextEnergy, steps + 1));
						}
					}
				}
			}
		}

		return -1;
	}

	private class State {
		int x, y, visited, energy, steps;

		public State(int x, int y, int visited, int energy, int steps) {
			this.x = x;
			this.y = y;
			this.visited = visited;
			this.energy = energy;
			this.steps = steps;
		}
	}
}

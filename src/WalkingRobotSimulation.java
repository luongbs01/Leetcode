import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/walking-robot-simulation/description/
 */

public class WalkingRobotSimulation {

	public int robotSim(int[] commands, int[][] obstacles) {
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		Set<List<Integer>> set = new HashSet<>();
		for (int[] obstacle : obstacles) {
			set.add(List.of(obstacle[0], obstacle[1]));
		}
		int x = 0, y = 0, currDirection = 0, ans = 0;
		for (int command : commands) {
			if (command == -2) {
				currDirection = (currDirection + 3) % 4;
			} else if (command == -1) {
				currDirection = (currDirection + 1) % 4;
			} else {
				for (int step = 1; step <= command; step++) {
					int nextX = x + directions[currDirection][0];
					int nextY = y + directions[currDirection][1];
					if (!set.contains(List.of(nextX, nextY))) {
						x = nextX;
						y = nextY;
						ans = Math.max(ans, x * x + y * y);
					}
				}
			}
		}
		return ans;
	}
}

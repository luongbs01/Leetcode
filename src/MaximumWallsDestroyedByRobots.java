import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-walls-destroyed-by-robots/description/
 */

public class MaximumWallsDestroyedByRobots {

	public int maxWalls(int[] robots, int[] distance, int[] walls) {
		int n = robots.length, samePos = 0;
		int[] cntLeft = new int[n];
		int[] cntRight = new int[n];
		int[] overlap = new int[n];
		int[][] dp = new int[n][2];

		HashMap<Integer, Integer> dist = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int wall : walls) {
			set.add(wall);
		}
		for (int i = 0; i < n; i++) {
			dist.put(robots[i], distance[i]);
			if (set.contains(robots[i])) {
				samePos++;
				set.remove(robots[i]);
			}
		}
		Arrays.sort(robots);
		walls = new int[set.size()];
		int index = 0;
		for (int i : set) {
			walls[index++] = i;
		}
		Arrays.sort(walls);

		for (int i = 0; i < n; i++) {
			cntLeft[i] = binarySearch(walls, Math.max(i > 0 ? robots[i - 1] : 0, robots[i] - dist.get(robots[i])), robots[i]);
			cntRight[i] = binarySearch(walls, robots[i], Math.min(i < n - 1 ? robots[i + 1] : Integer.MAX_VALUE, robots[i] + dist.get(robots[i])));
			overlap[i] = i < n - 1 ?
				binarySearch(walls, Math.max(robots[i], robots[i + 1] - dist.get(robots[i + 1])), Math.min(robots[i] + dist.get(robots[i]), robots[i + 1])) :
				0;
		}

		dp[0][0] = cntLeft[0];
		dp[0][1] = cntRight[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - overlap[i - 1]) + cntLeft[i];
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + cntRight[i];
		}
		return Math.max(dp[n - 1][0], dp[n - 1][1]) + samePos;
	}

	private int binarySearch(int[] walls, int from, int to) {
		int n = walls.length, leftIndex, rightIndex;
		if (n == 0 || from > to || to < walls[0] || from > walls[n - 1])
			return 0;
		int low = 0, high = n - 1;
		while (low < high) {
			int mid = (low + high) >> 1;
			if (walls[mid] >= from) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		leftIndex = low;

		low = 0;
		high = n - 1;
		while (low < high) {
			int mid = (low + high + 1) >> 1;
			if (walls[mid] <= to) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		rightIndex = high;
		return rightIndex - leftIndex + 1;
	}
}

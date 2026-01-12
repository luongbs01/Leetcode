/**
 * Description: https://leetcode.com/problems/minimum-time-visiting-all-points/
 */

public class MinimumTimeVisitingAllPoints {

	public int minTimeToVisitAllPoints(int[][] points) {
		int n = points.length, ans = 0;
		for (int i = 1; i < n; i++) {
			ans += minTime(points[i - 1], points[i]);
		}
		return ans;
	}

	// Chebyshev distance: https://en.wikipedia.org/wiki/Chebyshev_distance
	private int minTime(int[] point1, int[] point2) {
		int x1 = point1[0], y1 = point1[1];
		int x2 = point2[0], y2 = point2[1];
		return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	private int minTimeV1(int[] point1, int[] point2) {
		int x1 = point1[0], y1 = point1[1];
		int x2 = point2[0], y2 = point2[1];
		int min = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		min = Math.min(min, Math.abs(x2 - x1) + Math.abs(y2 - (y1 + x2 - x1)));
		min = Math.min(min, Math.abs(x2 - x1) + Math.abs(y2 - (y1 + x1 - x2)));
		min = Math.min(min, Math.abs(y2 - y1) + Math.abs(x2 - (x1 + y2 - y1)));
		min = Math.min(min, Math.abs(y2 - y1) + Math.abs(x2 - (x1 + y1 - y2)));
		return min;
	}
}

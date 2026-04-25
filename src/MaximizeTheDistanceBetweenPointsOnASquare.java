import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/description/
 */

public class MaximizeTheDistanceBetweenPointsOnASquare {

	public int maxDistance(int side, int[][] points, int k) {
		int n = points.length, index = 0;
		long[] arr = new long[n];
		for (int[] point : points) {
			if (point[0] == 0) {
				arr[index] = point[1];
			} else if (point[1] == side) {
				arr[index] = (long) side + point[0];
			} else if (point[0] == side) {
				arr[index] = 3L * side - point[1];
			} else {
				arr[index] = 4L * side - point[0];
			}
			index++;
		}
		Arrays.sort(arr);
		int l = 0, r = side;
		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (valid(arr, k, side, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	private boolean valid(long[] arr, int k, int side, int minDist) {
		long perimeter = 4L * side;
		for (int i = 0; i < arr.length; i++) {
			int curr = i;
			boolean found = true;
			for (int j = 1; j < k; j++) {
				curr = lowerBound(arr, arr[curr] + minDist);
				if (curr == arr.length || (arr[i] + perimeter) - arr[curr] < minDist) {
					found = false;
					break;
				}
			}
			if (found) {
				return true;
			}
		}
		return false;
	}

	private int lowerBound(long[] arr, long min) {
		int l = 0, r = arr.length;
		while (l < r) {
			int mid = (l + r) >> 1;
			if (arr[mid] < min) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}
}

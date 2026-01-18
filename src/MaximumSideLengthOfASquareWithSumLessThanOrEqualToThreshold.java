/**
 * Description: https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 */

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

	public int maxSideLength(int[][] mat, int threshold) {
		int m = mat.length, n = mat[0].length;
		int[][] prefixSum = new int[m][n];
		prefixSum[0][0] = mat[0][0];
		for (int i = 1; i < m; i++) {
			prefixSum[i][0] = prefixSum[i - 1][0] + mat[i][0];
		}
		for (int i = 1; i < n; i++) {
			prefixSum[0][i] = prefixSum[0][i - 1] + mat[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				prefixSum[i][j] = mat[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}
		int l = 0, r = Math.min(m, n);
		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (found(prefixSum, m, n, mid, threshold)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	private boolean found(int[][] prefixSum, int m, int n, int size, int threshold) {
		boolean found = false;
		for (int i = size - 1; i < m && !found; i++) {
			for (int j = size - 1; j < n; j++) {
				int a = i >= size ? prefixSum[i - size][j] : 0;
				int b = j >= size ? prefixSum[i][j - size] : 0;
				int c = (i >= size && j >= size) ? prefixSum[i - size][j - size] : 0;
				if (prefixSum[i][j] - a - b + c <= threshold) {
					found = true;
					break;
				}
			}
		}
		return found;
	}
}

/**
 * Description: https://leetcode.com/problems/maximum-matrix-sum/
 */

public class MaximumMatrixSum {

	public long maxMatrixSum(int[][] matrix) {
		long ans = 0;
		int cnt = 0, min = Integer.MAX_VALUE;
		for (int[] row : matrix) {
			for (int cell : row) {
				ans += Math.abs(cell);
				min = Math.min(min, Math.abs(cell));
				if (cell < 0) {
					cnt++;
				}
			}
		}
		return cnt % 2 == 0 ? ans : ans - 2 * min;
	}
}

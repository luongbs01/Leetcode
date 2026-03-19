/**
 * Description: https://leetcode.com/problems/equal-sum-grid-partition-i/description/
 */

public class EqualSumGridPartitionI {

	public boolean canPartitionGrid(int[][] grid) {
		int n = grid[0].length;
		long sum = 0, sum2 = 0;
		for (int[] row : grid) {
			for (int i : row) {
				sum += i;
			}
		}
		if (sum % 2 != 0)
			return false;

		for (int[] row : grid) {
			for (int i : row) {
				sum2 += i;
			}
			if (sum2 * 2 == sum) {
				return true;
			}
		}

		sum2 = 0;
		for (int i = 0; i < n; i++) {
			for (int[] row : grid) {
				sum2 += row[i];
			}
			if (sum2 * 2 == sum) {
				return true;
			}
		}

		return false;
	}
}

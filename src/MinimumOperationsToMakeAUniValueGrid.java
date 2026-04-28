import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 */

public class MinimumOperationsToMakeAUniValueGrid {

	public int minOperations(int[][] grid, int x) {
		int m = grid.length, n = grid[0].length, index = 0, mod = grid[0][0] % x, ans = Integer.MAX_VALUE;
		int[] arr = new int[m * n];
		int[] prefix = new int[m * n + 1];
		for (int[] row : grid) {
			for (int i = 0; i < n; i++) {
				if (row[i] % x != mod)
					return -1;
				arr[index++] = row[i] / x;
			}
		}
		Arrays.sort(arr);
		for (int i = 1; i <= arr.length; i++) {
			prefix[i] = prefix[i - 1] + arr[i - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			ans = Math.min(ans, prefix[arr.length] - prefix[i + 1] - prefix[i] + arr[i] * (2 * i + 1 - arr.length));
		}
		return ans;
	}
}

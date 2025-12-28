/**
 * Description: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */

public class CountNegativeNumbersInASortedMatrix {

	public int countNegatives(int[][] grid) {
		int m = grid.length, n = grid[0].length - 1, index = n, ans = 0;
		// use enhanced for loop take 99ms to run all test cases??
		for (int i = 0; i < m; i++) {
			while (index >= 0 && grid[i][index] < 0) {
				index--;
			}
			ans += n - index;
		}
		return ans;
	}
}

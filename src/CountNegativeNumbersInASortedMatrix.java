/**
 * Description: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */

public class CountNegativeNumbersInASortedMatrix {

	public int countNegatives(int[][] grid) {
		int n = grid[0].length - 1, index = n, ans = 0;
		for (int[] row : grid) {
			while (index >= 0 && row[index] < 0) {
				index--;
			}
			ans += n - index;
		}
		return ans;
	}
}

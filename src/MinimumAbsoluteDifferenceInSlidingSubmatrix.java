import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/
 */

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {

	public int[][] minAbsDiff(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int[][] ans = new int[m - k + 1][n - k + 1];
		for (int i = 0; i <= m - k; i++) {
			for (int j = 0; j <= n - k; j++) {
				List<Integer> list = new ArrayList<>(k * k);
				for (int x = i; x < i + k; x++) {
					for (int y = j; y < j + k; y++) {
						list.add(grid[x][y]);
					}
				}
				list.sort(Comparator.naturalOrder());
				int min = Integer.MAX_VALUE;
				for (int x = 1; x < k * k; x++) {
					if (list.get(x - 1) < list.get(x)) {
						min = Math.min(min, list.get(x) - list.get(x - 1));
					}
				}
				ans[i][j] = min == Integer.MAX_VALUE ? 0 : min;
			}
		}
		return ans;
	}
}

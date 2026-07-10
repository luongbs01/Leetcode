import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/description/
 */

public class PathExistenceQueriesInAGraphII {

	public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
		int[][] sorted = new int[n][2];
		int[] getIndex = new int[n];
		for (int i = 0; i < n; i++) {
			sorted[i][0] = nums[i];
			sorted[i][1] = i;
		}
		Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < n; i++) {
			getIndex[sorted[i][1]] = i;
		}

		int[][] up = new int[n][18];
		int r = 0;
		for (int i = 0; i < n; i++) {
			if (r < i) {
				r = i;
			}
			while (r + 1 < n &&
				sorted[r + 1][0] - sorted[r][0] <= maxDiff
				&& sorted[r + 1][0] - sorted[i][0] <= maxDiff) {
				r++;
			}
			up[i][0] = r;
		}
		for (int i = 1; i < 18; i++) {
			for (int j = 0; j < n; j++) {
				up[j][i] = up[up[j][i - 1]][i - 1];
			}
		}

		int m = queries.length;
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			int a = getIndex[queries[i][0]], b = getIndex[queries[i][1]];
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if (a == b) {
				ans[i] = 0;
			} else {
				int curr = a, cnt = 0;
				for (int j = 17; j >= 0; j--) {
					if (up[curr][j] < b) {
						curr = up[curr][j];
						cnt += (1 << j);
					}
				}
				if (up[curr][0] >= b) {
					// if sorted[b][0] - sorted[a][0] <= maxDiff => cnt = 0 => ans[i] = 1
					ans[i] = cnt + 1;
				} else {
					ans[i] = -1;
				}
			}
		}
		return ans;
	}
}

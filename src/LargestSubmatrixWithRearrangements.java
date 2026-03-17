import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/description/
 */

public class LargestSubmatrixWithRearrangements {

	// 43 ms
	public int largestSubmatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, ans = 0;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int size = 0, start = 0;
			if (matrix[0][i] == 1) {
				size = 1;
			}
			for (int j = 1; j < m; j++) {
				if (matrix[j][i] == 1) {
					if (matrix[j - 1][i] == 0) {
						size = 1;
						start = j;
					} else {
						size++;
					}
				} else if (matrix[j - 1][i] == 1) {
					for (int k = start; k < j; k++) {
						list.get(k).add(start + size - k);
					}
					size = 0;
				}
			}
			if (size > 0) {
				for (int k = start; k < m; k++) {
					list.get(k).add(start + size - k);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			if (!list.get(i).isEmpty()) {
				List<Integer> l = list.get(i);
				l.sort(Comparator.reverseOrder());
				int min = l.getFirst();
				for (int j = 0; j < l.size(); j++) {
					min = Math.min(min, l.get(j));
					ans = Math.max(ans, min * (j + 1));
				}
			}
		}
		return ans;
	}

	// 13 ms
	// idea from https://leetcode.com/problems/largest-submatrix-with-rearrangements/solutions/7653052/solution-by-la_castille-s27d
	public int largestSubmatrixV2(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, ans = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = matrix[i - 1][j] + 1;
				}
			}
		}
		for (int[] row : matrix) {
			Arrays.sort(row);
			int min = Integer.MAX_VALUE;
			for (int i = n - 1; i >= 0 && row[i] > 0; i--) {
				min = Math.min(min, row[i]);
				ans = Math.max(ans, min * (n - i));
			}
		}
		return ans;
	}
}

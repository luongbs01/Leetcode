import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/equal-sum-grid-partition-ii/description/
 */

public class EqualSumGridPartitionII {

	public boolean canPartitionGrid(int[][] grid) {
		int m = grid.length, n = grid[0].length, index = 0;
		int[] arr = new int[m * n];

		// Flatten row-by-row to check Horizontal cuts
		for (int[] row : grid) {
			for (int j = 0; j < n; j++) {
				arr[index++] = row[j];
			}
		}
		if (canPartitionArray(arr, m, n)) {
			return true;
		}

		// Flatten column-by-column to check Vertical cuts
		index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[index++] = grid[j][i];
			}
		}
		if (canPartitionArray(arr, n, m)) {
			return true;
		}
		return false;
	}

	private boolean canPartitionArray(int[] arr, int m, int n) {
		int index = 0;
		long sum = 0, sum1 = 0, sum2, diff;
		Map<Long, Integer> firstOccurrence = new HashMap<>();
		Map<Long, Integer> lastOccurrence = new HashMap<>();

		// Map values to their positions for O(1) lookup during split checks
		for (int i = 0; i < arr.length; i++) {
			firstOccurrence.putIfAbsent((long) arr[i], i);
			sum += arr[i];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			lastOccurrence.putIfAbsent((long) arr[i], i);
		}

		// Iterate through each possible split point (i is the row index of the cut)
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n; j++) {
				sum1 += arr[index++];
			}
			sum2 = sum - sum1;

			if (sum1 == sum2) {
				return true; // Already equal
			} else if (sum1 > sum2) {
				// Need to remove a cell from the 'Top' section
				diff = sum1 - sum2;

				// Connectivity Rule: If it's the first row or a 1D column,
				// only the corner/end cells can be removed.
				if ((i == 0 && (arr[0] == diff || arr[n - 1] == diff))
					|| (n == 1 && (arr[0] == diff || arr[index - 1] == diff))) {
					return true;
				}

				// If the section is >1 row and >1 column, any cell inside can be removed
				if (firstOccurrence.containsKey(diff)) {
					int pos = firstOccurrence.get(diff);
					if (pos < index && i > 0 && n > 1) {
						return true;
					}
				}
			} else {
				// Need to remove a cell from the 'Bottom' section
				diff = sum2 - sum1;

				if (lastOccurrence.containsKey(diff)) {
					int pos = lastOccurrence.get(diff);

					// Connectivity Rule: If it's the last row or a 1D column,
					// only the corner/end cells can be removed.
					if ((i == m - 2 && (arr[n * (m - 1)] == diff || arr[n * m - 1] == diff))
						|| (n == 1 && (arr[index] == diff || arr[m * n - 1] == diff))) {
						return true;
					}

					// If the section is >1 row and >1 column, any cell inside is valid
					if (pos >= index && i < m - 2 && n > 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

}

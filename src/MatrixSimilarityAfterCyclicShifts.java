/**
 * Description: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
 */

public class MatrixSimilarityAfterCyclicShifts {

	public boolean areSimilar(int[][] mat, int k) {
		int m = mat.length, n = mat[0].length;
		k = k % n;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (((i & 1) == 0 && mat[i][j] != mat[i][(j - k + n) % n])
					|| ((i & 1) != 0 && mat[i][j] != mat[i][(j + k) % n])) {
					return false;
				}
			}
		}
		return true;
	}
}

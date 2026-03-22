/**
 * Description: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
 */

public class DetermineWhetherMatrixCanBeObtainedByRotation {

	public boolean findRotation(int[][] mat, int[][] target) {
		int n = mat.length;
		if (equal(mat, target)) {
			return true;
		}

		int[][] mat2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat2[j][n - 1 - i] = mat[i][j];
			}
		}
		if (equal(mat2, target)) {
			return true;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat2[n - 1 - i][n - 1 - j] = mat[i][j];
			}
		}
		if (equal(mat2, target)) {
			return true;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat2[n - 1 - j][i] = mat[i][j];
			}
		}
		if (equal(mat2, target)) {
			return true;
		}

		return false;
	}

	private boolean equal(int[][] mat1, int[][] mat2) {
		int n = mat1.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat1[i][j] != mat2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

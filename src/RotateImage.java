import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/rotate-image/description/
 */

public class RotateImage {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// LinkedList: 1ms --> ArrayList: 0ms
		List<Integer> list = new ArrayList<>(n * n);
		for (int[] row : matrix) {
			for (int i : row) {
				list.add(i);
			}
		}
		Iterator<Integer> iterator = list.iterator();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				matrix[j][i] = iterator.next();
			}
		}
	}

	// in-place update
	public void rotateV2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}

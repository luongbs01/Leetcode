import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/set-matrix-zeroes/
 */

public class SetMatrixZeroes {

    // O(m*n) space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        for (int[] coordinate : coordinates) {
            for (int i = 0; i < m; i++) {
                matrix[i][coordinate[1]] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[coordinate[0]][i] = 0;
            }
        }
    }
}

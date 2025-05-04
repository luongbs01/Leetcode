import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/search-a-2d-matrix/description/
 */

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = matrix[i][j];
            }
        }
        return Arrays.binarySearch(arr, target) >= 0;
    }
}

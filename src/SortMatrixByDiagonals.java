import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/sort-matrix-by-diagonals/description/
 */

public class SortMatrixByDiagonals {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i < n - 1; i++) {
            int[] arr = new int[n - i];
            for (int j = 0; i + j < n; j++) {
                arr[j] = grid[j][i + j];
            }
            Arrays.sort(arr);
            for (int j = 0; i + j < n; j++) {
                grid[j][i + j] = arr[j];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int[] arr = new int[n - i];
            for (int j = 0; i + j < n; j++) {
                arr[j] = grid[i + j][j];
            }
            Arrays.sort(arr);
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = arr[arr.length - 1 - j];
            }
        }
        return grid;
    }
}

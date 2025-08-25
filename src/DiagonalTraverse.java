/**
 * Description: https://leetcode.com/problems/diagonal-traverse/description/
 */

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, index = 0, i = 0, j = 0;
        int[] ans = new int[m * n];
        ans[index++] = mat[i][j];
        ans[m * n - 1] = mat[m - 1][n - 1];
        // Simulation
        while (i < m || j < n) {
            if (j + 1 < n) {
                j++;
            } else {
                i++;
            }
            while (j >= 0 && i + 1 <= m) {
                ans[index++] = mat[i][j];
                i++;
                j--;
            }
            i--;
            j++;
            if (i + 1 < m) {
                i++;
            } else {
                j++;
            }
            while (i >= 0 && j + 1 <= n) {
                ans[index++] = mat[i][j];
                i--;
                j++;
            }
            i++;
            j--;
        }
        return ans;
    }
}

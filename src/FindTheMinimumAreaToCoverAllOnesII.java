/**
 * Description: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-ii/description/
 */

public class FindTheMinimumAreaToCoverAllOnesII {

    int ans = 1000;

    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rotatedGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedGrid[i][j] = grid[m - 1 - j][i];
            }
        }
        divide(grid);
        divide(rotatedGrid);
        return ans;
    }

    private void divide(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                ans = Math.min(ans, minArea(grid, 0, j, 0, i) + minArea(grid, j + 1, n - 1, 0, i) + minArea(grid, 0, n - 1, i + 1, m - 1));
                ans = Math.min(ans, minArea(grid, 0, n - 1, 0, i) + minArea(grid, 0, j, i + 1, m - 1) + minArea(grid, j + 1, n - 1, i + 1, m - 1));
            }
        }
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                ans = Math.min(ans, minArea(grid, 0, n - 1, 0, i) + minArea(grid, 0, n - 1, i + 1, j) + minArea(grid, 0, n - 1, j + 1, m - 1));
            }
        }
    }

    private int minArea(int[][] grid, int left, int right, int top, int bottom) {
        int r = left, l = right, t = bottom, b = top;
        boolean nonZero = false;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] == 1) {
                    r = Math.max(r, j);
                    l = Math.min(l, j);
                    t = Math.min(t, i);
                    b = Math.max(b, i);
                    nonZero = true;
                }
            }
        }
        return nonZero ? (b - t + 1) * (r - l + 1) : 1000;
    }
}

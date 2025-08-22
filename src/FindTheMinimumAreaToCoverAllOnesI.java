/**
 * Description: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/
 */

public class FindTheMinimumAreaToCoverAllOnesI {

    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int right = 0, bottom = 0, left = n, top = m;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    right = Math.max(right, j);
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}

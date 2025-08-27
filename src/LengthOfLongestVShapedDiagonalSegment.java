/**
 * Description: https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/description/
 */

public class LengthOfLongestVShapedDiagonalSegment {

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        // topLeft[i][j]: can move maximum topLeft[i][j] steps from (i,j) towards top-left
        // the furthest point that can be reached is (i-topLeft[i][j],j-topLeft[i][j])
        int[][] topLeft = new int[m][n], topRight = new int[m][n], bottomLeft = new int[m][n], bottomRight = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i > 0 && ((grid[i][j] == 0 && grid[i - 1][j - 1] == 2) || (grid[i][j] == 2 && grid[i - 1][j - 1] != 2)))
                    topLeft[i][j] = topLeft[i - 1][j - 1] + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (i > 0 && ((grid[i][j] == 0 && grid[i - 1][j + 1] == 2) || (grid[i][j] == 2 && grid[i - 1][j + 1] != 2)))
                    topRight[i][j] = topRight[i - 1][j + 1] + 1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (i < m - 1 && ((grid[i][j] == 0 && grid[i + 1][j - 1] == 2) || (grid[i][j] == 2 && grid[i + 1][j - 1] != 2)))
                    bottomLeft[i][j] = bottomLeft[i + 1][j - 1] + 1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (i < m - 1 && ((grid[i][j] == 0 && grid[i + 1][j + 1] == 2) || (grid[i][j] == 2 && grid[i + 1][j + 1] != 2)))
                    bottomRight[i][j] = bottomRight[i + 1][j + 1] + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ans = Math.max(ans, 1);
                int tl = grid[i - topLeft[i][j]][j - topLeft[i][j]], tr = grid[i - topRight[i][j]][j + topRight[i][j]],
                        br = grid[i + bottomRight[i][j]][j + bottomRight[i][j]], bl = grid[i + bottomLeft[i][j]][j - bottomLeft[i][j]];
                ans = Math.max(ans, tl * br == 1 ? topLeft[i][j] + bottomRight[i][j] : tl + br == 1 || tl + br == 3 ? topLeft[i][j] + bottomRight[i][j] + 1 : 0);
                ans = Math.max(ans, tr * bl == 1 ? topRight[i][j] + bottomLeft[i][j] : tr + bl == 1 || tr + bl == 3 ? topRight[i][j] + bottomLeft[i][j] + 1 : 0);

                // clockwise 90-degree turn
                ans = Math.max(ans, tl == 1 ? bl == 1 ? topLeft[i][j] + bottomLeft[i][j] : topLeft[i][j] + bottomLeft[i][j] + 1 : 0);
                ans = Math.max(ans, tr == 1 ? tl == 1 ? topLeft[i][j] + topRight[i][j] : topLeft[i][j] + topRight[i][j] + 1 : 0);
                ans = Math.max(ans, br == 1 ? tr == 1 ? topRight[i][j] + bottomRight[i][j] : topRight[i][j] + bottomRight[i][j] + 1 : 0);
                ans = Math.max(ans, bl == 1 ? br == 1 ? bottomLeft[i][j] + bottomRight[i][j] : bottomLeft[i][j] + bottomRight[i][j] + 1 : 0);
            }
        }
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
 */

public class MinimumXORPathInAGrid {

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] dp = new boolean[m][n][1024];
        dp[0][0][grid[0][0]] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 1024; k++) {
                    if (i > 0 && dp[i - 1][j][k]) {
                        dp[i][j][k ^ grid[i][j]] = true;
                    }
                    if (j > 0 && dp[i][j - 1][k]) {
                        dp[i][j][k ^ grid[i][j]] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 1024; i++) {
            if (dp[m - 1][n - 1][i]) {
                return i;
            }
        }
        return -1;
    }
}

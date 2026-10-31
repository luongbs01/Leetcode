/**
 * Description: https://leetcode.com/problems/twisted-mirror-path-count/
 */

public class TwistedMirrorPathCount {

    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length, MOD = 1_000_000_007;
        // dp[i][j[[0]: number of paths that enter cell (i,j) by moving down
        // dp[i][j[[1]: number of paths that enter cell (i,j) by moving right
        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (grid[i - 1][j] == 0) {
                        dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                    } else {
                        dp[i][j][0] = dp[i - 1][j][1];
                    }
                }
                if (j > 0) {
                    if (grid[i][j - 1] == 0) {
                        dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                    } else {
                        dp[i][j][1] = dp[i][j - 1][0];
                    }
                }
            }
        }
        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}

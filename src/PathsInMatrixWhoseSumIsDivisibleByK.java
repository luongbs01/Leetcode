/**
 * Description: https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/
 */

public class PathsInMatrixWhoseSumIsDivisibleByK {

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][k]; // dp[i][j][p]: nums of ways to get to position [i][j] and sum % k = p
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    dp[i][j][(p + grid[i][j]) % k] += (i > 0 ? dp[i - 1][j][p] : 0) + (j > 0 ? dp[i][j - 1][p] : 0);
                    dp[i][j][(p + grid[i][j]) % k] %= 1000000007;
                }
            }
        }
        return (int) dp[m - 1][n - 1][0] % 1000000007;
    }
}

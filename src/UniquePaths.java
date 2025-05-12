/**
 * Description: https://leetcode.com/problems/unique-paths/description/
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // possible unique paths to reach row i, col j
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        int i = 1, j;
        while (i < m) {
            j = 1;
            while (j < n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                j++;
            }
            i++;
        }
        return dp[m - 1][n - 1];
    }
}

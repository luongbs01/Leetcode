/**
 * Description: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/description/
 */

public class MinimumScoreTriangulationOfPolygon {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // dp[i][j]: minimum possible score that can be achieved with some triangulation of the polygon from ith vertex to jth vertex
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                dp[i][i + len] = Integer.MAX_VALUE;
                for (int k = 1; k < len; k++) {
                    dp[i][i + len] = Math.min(dp[i][i + len], dp[i][i + k] + dp[i + k][i + len] + values[i] * values[i + k] * values[i + len]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

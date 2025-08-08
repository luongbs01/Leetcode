/**
 * Description: https://leetcode.com/problems/soup-servings/description/
 */

public class SoupServings {

    public double soupServings(int n) {
        if (n > 5000) return 1;
        n = (int) Math.ceil(n / 25.0);
        // 1 serving = 25 ml
        // dp[i][j] be the answer to the problem when we start with i servings of soup A and j servings of soup B
        double[][] dp = new double[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
            dp[i][0] = 0;
        }
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][j - 1] + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[i - 1][Math.max(j - 3, 0)]) / 4;
                dp[j][i] = (dp[Math.max(j - 4, 0)][i] + dp[Math.max(j - 3, 0)][i - 1] + dp[Math.max(j - 2, 0)][Math.max(i - 2, 0)] + dp[j - 1][Math.max(i - 3, 0)]) / 4;
            }
        }
        return dp[n][n];
    }
}

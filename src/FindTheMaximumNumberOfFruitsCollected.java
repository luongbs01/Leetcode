/**
 * Description: https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/description/
 */

public class FindTheMaximumNumberOfFruitsCollected {

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
            fruits[i][i] = 0;
        }
        int[][] dp = new int[n][n];
        dp[0][n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= Math.max(i, n - i - 1); j--) {
                dp[i][j] = Math.max(dp[i][j], fruits[i][j] + dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], fruits[i][j] + dp[i - 1][j - 1]);
                if (j + 1 < n) {
                    dp[i][j] = Math.max(dp[i][j], fruits[i][j] + dp[i - 1][j + 1]);
                }
            }
        }
        ans += dp[n - 1][n - 1];

        dp[n - 1][0] = fruits[n - 1][0];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= Math.max(i, n - i - 1); j--) {
                dp[j][i] = Math.max(dp[j][i], fruits[j][i] + dp[j][i - 1]);
                dp[j][i] = Math.max(dp[j][i], fruits[j][i] + dp[j - 1][i - 1]);
                if (j + 1 < n) {
                    dp[j][i] = Math.max(dp[j][i], fruits[j][i] + dp[j + 1][i - 1]);
                }
            }
        }
        ans += dp[n - 1][n - 1];
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/edit-distance/description/
 */

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n2 + 1][n1 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                dp[i][j] = Math.min(
                        word2.charAt(i - 1) == word1.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1,
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[n2][n1];
    }
}

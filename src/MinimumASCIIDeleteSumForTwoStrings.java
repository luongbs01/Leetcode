/**
 * Description: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */

public class MinimumASCIIDeleteSumForTwoStrings {

	public int minimumDeleteSum(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = chars1[i - 1] + dp[i - 1][0];
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = chars2[j - 1] + dp[0][j - 1];
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (chars1[i - 1] == chars2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min((int) chars1[i - 1] + dp[i - 1][j], (int) chars2[j - 1] + dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}

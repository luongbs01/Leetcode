/**
 * Description: https://leetcode.com/problems/delete-operation-for-two-strings/
 */

public class DeleteOperationForTwoStrings {

	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (chars1[i - 1] == chars2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[m][n];
	}
}

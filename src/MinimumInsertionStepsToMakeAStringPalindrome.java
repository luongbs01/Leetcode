/**
 * Description: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */

public class MinimumInsertionStepsToMakeAStringPalindrome {

	public int minInsertions(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int[][] dp = new int[n][n];
		for (int diff = 1; diff < n; diff++) {
			for (int i = diff; i < n; i++) {
				if (chars[i - diff] == chars[i]) {
					dp[i - diff][i] = dp[i - diff + 1][i - 1];
				} else {
					dp[i - diff][i] = 1 + Math.min(dp[i - diff + 1][i], dp[i - diff][i - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}
}

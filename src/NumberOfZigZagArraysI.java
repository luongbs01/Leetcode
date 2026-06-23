/**
 * Description: https://leetcode.com/problems/number-of-zigzag-arrays-i/
 */

public class NumberOfZigZagArraysI {

	public int zigZagArrays(int n, int l, int r) {
		int size = r - l + 1, mod = 1_000_000_007;
		// dp[i][j][k]: number of zigzag array of length i, ending by (j + l)
		// k = 1 : peak, 0: bottom
		long[][][] dp = new long[n + 1][size][2];
		for (int i = 0; i < size - 1; i++) {
			dp[1][i][0] = 1;
			dp[1][size - 1 - i][1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < size; j++) {
				dp[i][j][1] = (dp[i][j - 1][1] + dp[i - 1][j - 1][0]) % mod;
				dp[i][size - 1 - j][0] = (dp[i][size - j][0] + dp[i - 1][size - j][1]) % mod;
			}
		}
		long ans = 0;
		for (int i = 0; i < size; i++) {
			ans = (ans + dp[n][i][0] + dp[n][i][1]) % mod;
		}
		return (int) ans;
	}
}

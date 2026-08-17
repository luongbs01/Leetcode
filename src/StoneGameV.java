/**
 * Description: https://leetcode.com/problems/stone-game-v/
 */

public class StoneGameV {

	public int stoneGameV(int[] stoneValue) {
		int n = stoneValue.length;
		int[] prefixSum = new int[n + 1];
		// dp[i][j]: maximum score Alice can achieve when playing optimally on subarray [i..j]
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
		}
		for (int len = 2; len <= n; len++) {
			for (int start = 0; start + len <= n; start++) {
				int end = start + len - 1;
				for (int i = start; i < end; i++) {
					int leftSum = prefixSum[i + 1] - prefixSum[start];
					int rightSum = prefixSum[end + 1] - prefixSum[i + 1];
					if (leftSum < rightSum) {
						dp[start][end] = Math.max(dp[start][end], leftSum + dp[start][i]);
					} else if (leftSum > rightSum) {
						dp[start][end] = Math.max(dp[start][end], rightSum + dp[i + 1][end]);
					} else {
						dp[start][end] = Math.max(dp[start][end], leftSum + dp[start][i]);
						dp[start][end] = Math.max(dp[start][end], rightSum + dp[i + 1][end]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}

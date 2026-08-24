/**
 * Description: https://leetcode.com/problems/stone-game-viii/
 */

public class StoneGameVIII {

	public int stoneGameVIII(int[] stones) {
		int n = stones.length;
		int[] prefix = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefix[i] = prefix[i - 1] + stones[i - 1];
		}

		// dp[i]: maximum diff a player gains over opponent when playing optimally on subarray [i..n-1]
		// dp[n - 2] = prefix[n];
		// dp[n - 3] = max(prefix[n], prefix[n - 1] - dp[n - 2]) = max(dp[n - 2], prefix[n - 1] - dp[n - 2]);
		// dp[n - 4] = max(prefix[n], prefix[n - 1] - dp[n - 2], prefix[n - 2] - dp[n - 3]) = max(dp[n - 3], prefix[n - 2] - dp[n - 3]);
		int[] dp = new int[n - 1];
		dp[n - 2] = prefix[n];
		for (int i = n - 3; i >= 0; i--) {
			dp[i] = Math.max(dp[i + 1], prefix[i + 2] - dp[i + 1]);
		}
		return dp[0];
	}
}

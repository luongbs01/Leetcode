import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/stone-game-iii/
 */

public class StoneGameIII {

	public String stoneGameIII(int[] stones) {
		int n = stones.length;
		// dp[i]: maximum score difference a player can gain over opponent when playing on subarray [i..n-1] optimally
		int[] dp = new int[n];
		dp[n - 1] = stones[n - 1];
		if (n >= 2)
			dp[n - 2] = Math.max(stones[n - 2] + stones[n - 1], stones[n - 2] - dp[n - 1]);
		if (n >= 3)
			dp[n - 3] = Math.max(stones[n - 3] + stones[n - 2] + stones[n - 1],
				Math.max(stones[n - 3] + stones[n - 2] - dp[n - 1], stones[n - 3] - dp[n - 2]));
		for (int i = n - 4; i >= 0; i--) {
			dp[i] = Math.max(stones[i] - dp[i + 1], Math.max(stones[i] + stones[i + 1] - dp[i + 2],
				stones[i] + stones[i + 1] + stones[i + 2] - dp[i + 3]));
		}
		return dp[0] > 0 ? "Alice" : (dp[0] < 0 ? "Bob" : "Tie");
	}
}

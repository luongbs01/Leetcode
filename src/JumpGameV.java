import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/jump-game-v/description/
 */

// Easy to visualize and understand solution:
// https://leetcode.com/problems/jump-game-v/solutions/8289742/naruto-beats-100-see-it-in-action-by-nan-2xff
public class JumpGameV {

	// dp[i]: maximum number of indices reachable starting from i
	int[] dp;

	public int maxJumps(int[] arr, int d) {
		int n = arr.length, ans = 1;
		dp = new int[n];
		Arrays.fill(dp, -1);
		for (int i = 0; i < n; i++) {
			dp[i] = dfs(arr, n, i, d);
		}

		for (int i : dp) {
			ans = Math.max(ans, i);
		}
		return ans;
	}

	private int dfs(int[] arr, int n, int start, int d) {
		if (dp[start] != -1) {
			return dp[start];
		}
		int max = 1;
		for (int i = start - 1; i >= Math.max(start - d, 0) && arr[i] < arr[start]; i--) {
			dp[i] = dfs(arr, n, i, d);
			max = Math.max(max, 1 + dp[i]);
		}
		for (int i = start + 1; i <= Math.min(start + d, n - 1) && arr[i] < arr[start]; i++) {
			dp[i] = dfs(arr, n, i, d);
			max = Math.max(max, 1 + dp[i]);
		}
		dp[start] = max;
		return dp[start];
	}
}

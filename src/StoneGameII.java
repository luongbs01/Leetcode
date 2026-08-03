import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/stone-game-ii/
 */

public class StoneGameII {

	int[][] dp;

	public int stoneGameII(int[] piles) {
		int n = piles.length, sum = 0;
		dp = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		for (int pile : piles) {
			sum += pile;
		}
		return (sum + maxDiff(piles, n, 0, 1)) / 2;
	}

	// maximum score difference a player can gain over opponent when playing optimally on subarray[start..n-1], m
	private int maxDiff(int[] piles, int n, int start, int m) {
		if (start + 2 * m >= n) {
			int sum = 0;
			for (int i = start; i < n; i++) {
				sum += piles[i];
			}
			return sum;
		}
		if (dp[start][m] != Integer.MIN_VALUE) {
			return dp[start][m];
		}
		int max = Integer.MIN_VALUE, prefixSum = 0;
		for (int i = start; i < Math.min(start + m * 2, n); i++) {
			prefixSum += piles[i];
			max = Math.max(max, prefixSum - maxDiff(piles, n, i + 1, Math.max(m, i - start + 1)));
		}
		return dp[start][m] = max;
	}
}

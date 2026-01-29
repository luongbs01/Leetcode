import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/
 */

public class MinimumCostToConvertStringI {

	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		// dp[i][j]: minimum cost to convert from (char) (i + 'a') to (char) (j + 'a')
		int[][] dp = new int[26][26];
		for (int i = 0; i < 26; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][i] = 0; // IMPORTANT
		}
		for (int i = 0; i < original.length; i++) {
			dp[original[i] - 'a'][changed[i] - 'a'] = Math.min(dp[original[i] - 'a'][changed[i] - 'a'], cost[i]);
		}

		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
					}
				}
			}
		}

		char[] sourceChars = source.toCharArray();
		char[] targetChars = target.toCharArray();
		long ans = 0;
		for (int i = 0; i < sourceChars.length; i++) {
			int minCost = dp[sourceChars[i] - 'a'][targetChars[i] - 'a'];
			if (minCost == Integer.MAX_VALUE) {
				return -1;
			}
			ans += minCost;
		}
		return ans;
	}
}

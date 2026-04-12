import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/description/
 */

public class MinimumDistanceToTypeAWordUsingTwoFingers {

	public int minimumDistance(String word) {
		int n = word.length(), ans = Integer.MAX_VALUE;
		char[] chars = word.toCharArray();
		// dp[i][j][k]: minimum distance after typing chars[i] and first finger at j and second finger at k
		// either first finger or second finger has to be at chars[i]
		int[][][] dp = new int[n][26][26];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
			}
		}

		for (int i = 0; i < 26; i++) {
			int curr = chars[0] - 'A';
			dp[0][i][curr] = 0;
			dp[0][curr][i] = 0;
		}

		for (int i = 1; i < n; i++) {
			int prev = chars[i - 1] - 'A';
			int curr = chars[i] - 'A';
			int dist = calcDist(prev, curr);
			for (int j = 0; j < 26; j++) {
				dp[i][j][curr] = Math.min(dp[i][j][curr], Math.min(dp[i - 1][j][prev] + dist, dp[i - 1][prev][curr] + calcDist(prev, j)));
				dp[i][curr][j] = Math.min(dp[i][curr][j], Math.min(dp[i - 1][prev][j] + dist, dp[i - 1][curr][prev] + calcDist(prev, j)));
			}
		}

		for (int i = 0; i < 26; i++) {
			ans = Math.min(ans, Math.min(dp[n - 1][i][chars[n - 1] - 'A'], dp[n - 1][chars[n - 1] - 'A'][i]));
		}
		return ans;
	}

	private int calcDist(int prev, int curr) {
		return Math.abs(prev / 6 - curr / 6) + Math.abs(prev % 6 - curr % 6);
	}
}

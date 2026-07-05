import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/number-of-paths-with-max-score/
 */

public class NumberOfPathsWithMaxScore {

	public int[] pathsWithMaxScore(List<String> board) {
		int n = board.getFirst().length(), mod = 1_000_000_007;
		int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };
		int[][] dp = new int[n][n];
		int[][] ways = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		dp[n - 1][n - 1] = 0;
		ways[n - 1][n - 1] = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				char c = board.get(i).charAt(j);
				if (c == 'X') {
					continue;
				}
				int max = -1, cnt = 0;
				for (int[] direction : directions) {
					int prevX = i + direction[0], prevY = j + direction[1];
					if (prevX < n && prevY < n) {
						if (dp[prevX][prevY] > max) {
							max = dp[prevX][prevY];
							cnt = ways[prevX][prevY];
						} else if (dp[prevX][prevY] == max) {
							cnt = (cnt + ways[prevX][prevY]) % mod;
						}
					}
				}

				if (max > -1) {
					dp[i][j] = c != 'E' ? max + (c - '0') : max;
					ways[i][j] = cnt;
				}
			}
		}

		if (dp[0][0] == -1) {
			return new int[] { 0, 0 };
		}
		return new int[] { dp[0][0], ways[0][0] };
	}
}

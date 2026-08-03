/**
 * Description: https://leetcode.com/problems/stone-game-iv/
 */

public class StoneGameIV {

	public boolean winnerSquareGame(int n) {
		// dp[i]: can current player win the game with initial i stones when playing optimally
		boolean[] dp = new boolean[n + 1];
		dp[0] = dp[1] = true;
		for (int i = 2; i <= n; i++) {
			boolean canWin = false;
			for (int j = 1; j * j <= i; j++) {
				if (j * j == i || !dp[i - j * j]) {
					canWin = true;
					break;
				}
			}
			dp[i] = canWin;
		}
		return dp[n];
	}
}

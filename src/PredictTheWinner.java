/**
 * Description: https://leetcode.com/problems/predict-the-winner/
 */

public class PredictTheWinner {

	public boolean predictTheWinner(int[] nums) {
		int n = nums.length;
		// dp[i][j]: maximum diff between player 1 and player 2 when player 1 takes first on subarray [i..j]
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = nums[i];
		}
		for (int dist = 1; dist < n; dist++) {
			for (int i = 0; i < n - dist; i++) {
				dp[i][i + dist] = Math.max(nums[i] - dp[i + 1][i + dist], nums[i + dist] - dp[i][i + dist - 1]);
			}
		}
		return dp[0][n - 1] >= 0;
	}
}

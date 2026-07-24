/**
 * Description: https://oj.vnoi.info/problem/linegame
 */

public class LineGame {

	public long bangSo(int[] nums) {
		int n = nums.length;
		// dp[i][0]: max to nums[i], picked even
		// dp[i][1]: max to nums[i], picked odd
		long[][] dp = new long[n][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
		}
		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 9, 2, 4, 1, 3, 7 };
		System.out.printf("" + new LineGame().bangSo(arr));
	}
}

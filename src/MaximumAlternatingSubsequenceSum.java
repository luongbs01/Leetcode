/**
 * Description: https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 */

public class MaximumAlternatingSubsequenceSum {

	public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		// dp[i][0]: maximum sum of subsequence of array[0..i], subsequence has even elements
		// dp[i][1]: maximum sum of subsequence of array[0..i], subsequence has odd elements
		long[][] dp = new long[n][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
		}
		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}
}

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */

public class NumberOfLongestIncreasingSubsequence {

	public int findNumberOfLIS_V1(int[] nums) {
		int n = nums.length, max = 1, ans = 0;
		int[] dp = new int[n]; // dp[i]: LIS ending at i
		int[] cnt = new int[n]; // cnt[i]: number of LIS ending at i
		Arrays.fill(dp, 1);
		cnt[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
			if (dp[i] == 1) {
				cnt[i] = 1;
			} else {
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
						cnt[i] += cnt[j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (dp[i] == max) {
				ans += cnt[i];
			}
		}
		return ans;
	}

	public int findNumberOfLIS_V2(int[] nums) {
		int n = nums.length, max = 1, ans = 0;
		int[] dp = new int[n]; // dp[i]: LIS ending at i
		int[] cnt = new int[n]; // cnt[i]: number of LIS ending at i
		Arrays.fill(dp, 1);
		Arrays.fill(cnt, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						cnt[i] = cnt[j];
					} else if (dp[j] + 1 == dp[i]) {
						cnt[i] += cnt[j];
					}
				}
			}
			max = Math.max(max, dp[i]);

		}
		for (int i = 0; i < n; i++) {
			if (dp[i] == max) {
				ans += cnt[i];
			}
		}
		return ans;
	}
}

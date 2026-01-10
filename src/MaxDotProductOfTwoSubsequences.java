import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
 */

public class MaxDotProductOfTwoSubsequences {

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], -1_000_001);
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j], nums1[i - 1] * nums2[j - 1]);
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}
		return dp[m][n];
	}
}

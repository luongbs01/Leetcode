import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
 */

public class MaxDotProductOfTwoSubsequences {

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], -1_000_001);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
				if (i > 0 && j > 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
				}
				if (j > 0)
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				if (i > 0)
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}
		return dp[m - 1][n - 1];
	}
}

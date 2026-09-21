/**
 * Description: https://leetcode.com/problems/find-x-value-of-array-i/description/
 */

public class FindXValueOfArrayI {

    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] ans = new long[k];
        // dp[i][j]: number of subarray ending at i and product % k equals j
        long[][] dp = new long[n][k];
        ans[nums[0] % k] = dp[0][nums[0] % k] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][(int) (((long) j * nums[i]) % k)] += dp[i - 1][j];
                dp[i][j] += (nums[i] % k == j) ? 1 : 0;
            }

            for (int j = 0; j < k; j++) {
                ans[j] += dp[i][j];
            }
        }
        return ans;
    }
}

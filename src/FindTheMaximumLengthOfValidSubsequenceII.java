import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/
 */

public class FindTheMaximumLengthOfValidSubsequenceII {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        //dp[i][j] = longest subsequence ending at element i with remainder j.
        // Similar to longest common subsequence
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] % k + nums[j] % k) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                ans = Math.max(ans, dp[i][mod]);
            }
        }
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/
 */

public class MaximumSubarraySumWithLengthDivisibleByK {

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n]; // dp[i]: maximum sum of subarray ending at i and size is divisible by k
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        dp[k - 1] = prefix[k - 1];
        long ans = dp[k - 1];
        for (int i = k; i < n; i++) {
            dp[i] = Math.max(dp[i - k] + prefix[i] - prefix[i - k], prefix[i] - prefix[i - k]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

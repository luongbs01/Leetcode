/**
 * Description: https://leetcode.com/problems/maximum-subarray/description/
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]: largest sum of subarray ending at i
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

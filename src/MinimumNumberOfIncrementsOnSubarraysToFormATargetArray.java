import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/
 */

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {

    public int minNumberOperations(int[] target) {
        int n = target.length;
        // dp[i]: minimum number of operations to form a target from index 0 to i
        int[] dp = new int[n];
        dp[0] = target[0];
        for (int i = 1; i < n; i++) {
            if (target[i] <= target[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + (target[i] - target[i - 1]);
            }
        }
        return dp[n - 1];
    }
}

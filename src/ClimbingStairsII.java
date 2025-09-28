import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/climbing-stairs-ii/
 */

public class ClimbingStairsII {

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[i - 1] + 1);
            if (i >= 2) dp[i] = Math.min(dp[i], dp[i - 2] + costs[i - 1] + 4);
            if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + costs[i - 1] + 9);
        }
        return dp[n];
    }
}

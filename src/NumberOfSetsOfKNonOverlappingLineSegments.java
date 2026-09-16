import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
 */

public class NumberOfSetsOfKNonOverlappingLineSegments {

    public int numberOfSets(int n, int k) {
        long ans = 0, MOD = 1_000_000_007;

        // dp[i][j]: number of sets of i non-overlapping segments, last segments ending at j
        // dp[i][j] = dp[i-1][j-1] * 1 + dp[i-1][j-2] * 2 + .. + dp[i-1][i-1] * (j - i + 1)
        // dp[i][j+1] = dp[i-1][j] * 1 + dp[i-1][j-1] * 2 + .. + dp[i-1][i-1] * (j - i + 2)
        // => dp[i][j+1]-dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + .. + dp[i-1][i-1] = prefixSum(dp[i-1][i-1],dp[i-1][j])
        // => dp[i][j+1] = prefixSum(dp[i-1][i-1],dp[i-1][j]) + dp[i][j]
        long[][] dp = new long[k + 1][n];

        // base case
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            long prefixSum = 0;
            for (int j = i; j < n; j++) {
                prefixSum += dp[i - 1][j - 1];
                dp[i][j] = (dp[i][j - 1] + prefixSum) % MOD;
            }
        }

        for (int i = k; i < n; i++) {
            ans = (ans + dp[k][i]) % MOD;
        }
        return (int) (ans % MOD);
    }
}

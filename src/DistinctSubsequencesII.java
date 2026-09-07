import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/distinct-subsequences-ii/
 */

public class DistinctSubsequencesII {

    public int distinctSubseqII(String s) {
        int n = s.length(), MOD = 1_000_000_007;
        char[] chars = s.toCharArray();
        // dp[i]: number of distinct subsequences on substring [0..(i-1)]
        long[] dp = new long[n + 1];
        long[] duplicate = new long[26];
        Arrays.fill(duplicate, -1);
        dp[0] = 1; // empty string
        for (int i = 0; i < n; i++) {
            dp[i + 1] = (dp[i] * 2) % MOD;
            if (duplicate[chars[i] - 'a'] != -1) {
                dp[i + 1] = (dp[i + 1] + MOD - duplicate[chars[i] - 'a']) % MOD;
            }
            duplicate[chars[i] - 'a'] = dp[i];
        }
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}

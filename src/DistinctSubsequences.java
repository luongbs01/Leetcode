/**
 * Description: https://leetcode.com/problems/distinct-subsequences/
 */

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // dp[i][j]: number of subsequences ending at j and equals t[0..i]
        int[][] dp = new int[n][m];

        // base case
        for (int j = 0; j < m; j++) {
            if (tChars[0] == sChars[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int total = 0;
            for (int j = i; j < m; j++) {
                total += dp[i - 1][j - 1];
                if (tChars[i] == sChars[j]) {
                    dp[i][j] = total;
                }
            }
        }

        int ans = 0;
        for (int i = n - 1; i < m; i++) {
            ans += dp[n - 1][i];
        }
        return ans;
    }
}

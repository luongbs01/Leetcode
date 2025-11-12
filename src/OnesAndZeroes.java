/**
 * Description: https://leetcode.com/problems/ones-and-zeroes/description/
 */

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            char[] chars = strs[i - 1].toCharArray();
            int zeros = 0, ones = 0;
            for (char c : chars) {
                if (c == '0')
                    zeros++;
                else
                    ones++;
            }
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

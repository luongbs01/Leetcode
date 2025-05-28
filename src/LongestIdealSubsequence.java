/**
 * Description: https://leetcode.com/problems/longest-ideal-subsequence/description/
 */

public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            char from = (char) Math.max('a', c - k);
            char to = (char) Math.min('z', c + k);
            int max = 0;
            for (char c1 = from; c1 <= to; c1++) {
                max = Math.max(max, dp[c1 - 'a'] + 1);
            }
            dp[c - 'a'] = max;
            ans = Math.max(ans, dp[c - 'a']);
        }
        return ans;
    }
}

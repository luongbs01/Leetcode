/**
 * Description: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1, startPos = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if (i + 1 < length && charArray[i] == charArray[i + 1]) {
                dp[i][i + 1] = true;
                maxLength = 2;
                startPos = i;
            }
        }
        for (int diff = 2; diff < length; diff++) {
            for (int i = 0; i < length - diff; i++) {
                dp[i][i + diff] = dp[i + 1][i + diff - 1] && charArray[i] == charArray[i + diff];
                if (dp[i][i + diff]) {
                    maxLength = diff + 1;
                    startPos = i;
                }
            }
        }
        return s.substring(startPos, startPos + maxLength);
    }
}

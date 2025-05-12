/**
 * Description: https://leetcode.com/problems/longest-common-subsequence/
 */

public class LongestCommonSubsequence {

    // 18ms
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        // dp[i][j]: length of the longest common subsequence on text1 ending at i, text2 ending at j
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }

    // string to charArray => 8ms
    public int longestCommonSubsequenceV2(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        // length of the longest common subsequence on text1 ending at i, text2 ending at j
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public int longestCommonSubsequenceV3(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        // length of the longest common subsequence on text1 ending at i, text2 ending at j
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}

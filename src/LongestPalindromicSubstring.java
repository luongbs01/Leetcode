/**
 * Description: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int firstIndex = 0, lastIndex = 0;
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
            firstIndex = i;
            lastIndex = i;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                firstIndex = i;
                lastIndex = i + 1;
            }
        }
        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                if (s.charAt(i) == s.charAt(diff + i) && isPalindrome[i + 1][diff + i - 1]) {
                    isPalindrome[i][diff + i] = true;
                    firstIndex = i;
                    lastIndex = diff + i;
                }
            }
        }
        return s.substring(firstIndex, lastIndex + 1);
    }
}

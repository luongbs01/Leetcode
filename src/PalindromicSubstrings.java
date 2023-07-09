/**
 * Description: https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
            ans++;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                ans++;
            }
        }
        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                if (s.charAt(i) == s.charAt(diff + i) && isPalindrome[i + 1][diff + i - 1]) {
                    isPalindrome[i][diff + i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int length = s.length(), ans = 0;
        char[] charArr = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            ans++;
            if (i + 1 < length && charArr[i] == charArr[i + 1]) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        for (int diff = 2; diff < length; diff++) {
            System.out.println("dif: " + diff + ", ans before: " + ans);
            for (int i = 0; i < length - diff; i++) {
                dp[i][i + diff] = dp[i + 1][i + diff - 1] && charArr[i] == charArr[i + diff];
                if (dp[i][i + diff]) {
                    ans++;
                }
            }
            System.out.println("dif: " + diff + ", ans after: " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("aaaa"));
    }
}

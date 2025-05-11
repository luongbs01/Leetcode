import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 1;
        Set<String> validNumbers = new HashSet<>();
        for (int i = 1; i < 27; i++) {
            validNumbers.add(String.valueOf(i));
        }
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) > '0' && validNumbers.contains(s.substring(i - 2, i))) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else if (s.charAt(i - 1) > '0') {
                dp[i] = dp[i - 1];
            } else if (validNumbers.contains(s.substring(i - 2, i))) {
                dp[i] = dp[i - 2];
            } else {
                dp[i] = 0;
            }
        }
        return dp[length];
    }
}

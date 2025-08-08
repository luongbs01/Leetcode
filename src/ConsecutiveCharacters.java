/**
 * Description: https://leetcode.com/problems/consecutive-characters/description/
 */

public class ConsecutiveCharacters {

    public int maxPower(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 1, count = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                count = 1;
            } else {
                count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}

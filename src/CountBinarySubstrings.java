/**
 * Description: https://leetcode.com/problems/count-binary-substrings/description/
 */

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int n = s.length(), curr = 1, prev = 0, ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == chars[i]) {
                curr++;
            } else {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        return ans + Math.min(curr, prev);
    }
}

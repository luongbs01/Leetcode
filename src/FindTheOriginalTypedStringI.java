/**
 * Description: https://leetcode.com/problems/find-the-original-typed-string-i/
 */

public class FindTheOriginalTypedStringI {

    public int possibleStringCount(String word) {
        int ans = 1, n = word.length(), cnt = 0;
        char[] chars = word.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                cnt++;
            } else if (cnt > 0) {
                ans += cnt;
                cnt = 0;
            }
        }
        if (cnt > 0) {
            ans += cnt;
        }
        return ans;
    }
}

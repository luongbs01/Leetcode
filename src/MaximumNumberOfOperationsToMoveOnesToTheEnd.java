/**
 * Description: https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/
 */

public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public int maxOperations(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, ans = 0, count = chars[0] == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == '0' && chars[i - 1] == '1') {
                ans += count;
            } else if (chars[i] == '1') {
                count++;
            }
        }
        return ans;
    }
}

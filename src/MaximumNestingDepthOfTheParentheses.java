/**
 * Description: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */

public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            } else if (c == ')') {
                cnt--;
            }
        }
        return ans;
    }
}

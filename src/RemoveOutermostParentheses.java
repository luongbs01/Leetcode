/**
 * Description: https://leetcode.com/problems/remove-outermost-parentheses/
 */

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        int prev, curr = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            prev = curr;
            if (c == '(') {
                curr++;
            } else {
                curr--;
            }
            if (prev != 0 && curr != 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int closing = 0, opening = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                opening++;
            } else if (opening > 0) {
                opening--;
            } else {
                closing++;
            }
        }
        return opening + closing;
    }
}

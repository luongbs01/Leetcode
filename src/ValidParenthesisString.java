import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/valid-parenthesis-string/
 */

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        ArrayDeque<Integer> opening = new ArrayDeque<>();
        ArrayDeque<Integer> asterisk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                opening.push(i);
            } else if (chars[i] == '*') {
                asterisk.push(i);
            } else if (!opening.isEmpty()) {
                opening.pop();
            } else if (!asterisk.isEmpty()) {
                asterisk.pop();
            } else {
                return false;
            }
        }
        while (!opening.isEmpty() && !asterisk.isEmpty()) {
            if (opening.peek() > asterisk.peek()) {
                return false;
            }
            opening.pop();
            asterisk.pop();
        }
        return opening.isEmpty();
    }
}

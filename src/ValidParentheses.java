import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/valid-parentheses/description/
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (!stack.isEmpty()
                    && ((c == ')' && stack.peek() == '(')
                    || (c == ']' && stack.peek() == '[')
                    || (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}

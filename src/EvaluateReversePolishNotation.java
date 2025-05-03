import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/daily-temperatures/description/
 */

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = switch (token) {
                    case "+" -> first + second;
                    case "-" -> first - second;
                    case "*" -> first * second;
                    case "/" -> first / second;
                    default -> 0;
                };
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

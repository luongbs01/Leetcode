import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/generate-parentheses/description/
 */

public class GenerateParentheses {
    List<String> ans;
    int length;
    int n;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        length = n * 2;
        this.n = n;
        generate(0, "");
        return ans;
    }

    private void generate(int i, String s) {
        if (i == length) {
            if (isValid(s)) {
                ans.add(s);
            }
        } else {
            generate(i + 1, s + "(");
            generate(i + 1, s + ")");
        }
    }

    private boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 54ms
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < length; i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && chars[i] == ')') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    private void generateV2(int i, String s, int open, int close) {
        if (i == length) {
            if (isValid(s)) {
                ans.add(s);
            }
            // pruning -> 6ms
        } else if (open >= close && open <= n) {
            generateV2(i + 1, s + "(", open + 1, close);
            generateV2(i + 1, s + ")", open, close + 1);
        }
    }

    private boolean isValidV2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // Stack: 6ms ---> ArrayDeque: 4ms
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < length; i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && chars[i] == ')') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    // Refer to https://wiki.vnoi.info/algo/data-structures/Stack
    // 4ms ---> 2ms
    private void generateV3(int i, String s, int open, int close) {
        if (i == n * 2) {
            if (open == close) {
                ans.add(s);
            }
        } else if (open >= close && open <= n) {
            generateV3(i + 1, s + "(", open + 1, close);
            generateV3(i + 1, s + ")", open, close + 1);
        }
    }
}

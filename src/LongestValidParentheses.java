import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-valid-parentheses/description/
 */

public class LongestValidParentheses {

    // line sweeping
    public int longestValidParentheses(String s) {
        int n = s.length(), ans = 0;
        if (n < 2) return 0;
        char[] chars = s.toCharArray();
        int[] pre = new int[n];
        Map<Integer, List<Integer>> points = new HashMap<>();
        pre[0] = chars[0] == '(' ? 1 : -1;
        points.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);
        points.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(0);
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (chars[i] == '(' ? 1 : -1);
            points.computeIfAbsent(pre[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : points.values()) {
            if (list.size() >= 2) {
                int len = 0, size = list.size();
                for (int i = 1; i < size; i++) {
                    if (pre[list.get(i) - 1] > pre[list.get(i)]) {
                        len += (list.get(i) - list.get(i - 1));
                        ans = Math.max(ans, len);
                    } else {
                        len = 0;
                    }
                }
            }
        }
        return ans;
    }

    // stack
    public int longestValidParenthesesV2(String s) {
        int n = s.length(), ans = 0;
        char[] chars = s.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}

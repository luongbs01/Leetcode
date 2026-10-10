import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 */

public class MinimumInsertionsToBalanceAParenthesesString {

    public int minInsertions(String s) {
        int n = s.length(), ans = 0;
        char[] chars = s.toCharArray();
        ArrayDeque<Integer> open = new ArrayDeque<>();
        List<Integer> close = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                open.push(i);
            } else {
                close.add(i);
                if (!open.isEmpty() && close.size() > 1 && open.peek() < close.get(close.size() - 2)
                        && close.get(close.size() - 2) + 1 == close.getLast()) {
                    open.pop();
                    close.removeLast();
                    close.removeLast();
                }
            }
        }
        while (!open.isEmpty()) {
            if (!close.isEmpty() && open.peek() < close.getLast()) {
                ans++;
                open.pop();
                close.removeLast();
            } else {
                ans += 2;
                open.pop();
            }
        }
        while (!close.isEmpty()) {
            if (close.size() > 1 && close.get(close.size() - 2) + 1 == close.getLast()) {
                ans++;
                close.removeLast();
                close.removeLast();
            } else {
                ans += 2;
                close.removeLast();
            }
        }
        return ans;
    }
}

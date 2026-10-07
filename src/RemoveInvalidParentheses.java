import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/remove-invalid-parentheses/
 */

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(1 << Math.min(20, s.length()));
        queue.add(s);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String string = queue.poll();
                if (isValid(string)) {
                    ans.add(string);
                } else {
                    for (int j = 0; j < string.length(); j++) {
                        String str = string.substring(0, j) + string.substring(j + 1);
                        if (!set.contains(str)) {
                            set.add(str);
                            queue.offer(str);
                        }
                    }
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
        return new ArrayList<>();
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/unique-3-digit-even-numbers/
 */

public class Unique3DigitEvenNumbers {

    public int totalNumbers(int[] digits) {
        int n = digits.length, ans = 0;
        boolean[] marked = new boolean[1001];
        backtrack(n, digits, new boolean[10], marked, new ArrayList<>(3));
        for (int i = 100; i < 1000; i++) {
            ans += marked[i] && (i & 1) == 0 ? 1 : 0;
        }
        return ans;
    }

    private void backtrack(int n, int[] digits, boolean[] visited, boolean[] marked, List<Integer> list) {
        if (list.size() == 3) {
            marked[list.get(0) * 100 + list.get(1) * 10 + list.get(2)] = true;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(digits[i]);
                    backtrack(n, digits, visited, marked, list);
                    list.removeLast();
                    visited[i] = false;
                }
            }
        }
    }
}

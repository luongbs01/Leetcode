import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
 */

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            queue.offer(i);
        }
        for (int i = 1; i < n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int curr = queue.poll();
                int lastDigit = curr % 10;
                if (k == 0) {
                    queue.offer(curr * 10 + lastDigit);
                } else {
                    if (k > 0 && lastDigit - k >= 0) {
                        queue.offer(curr * 10 + lastDigit - k);
                    }
                    if (k > 0 && lastDigit + k < 10) {
                        queue.offer(curr * 10 + lastDigit + k);
                    }
                }
            }
        }
        int[] ans = new int[queue.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}

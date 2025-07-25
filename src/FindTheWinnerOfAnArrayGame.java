import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/find-the-winner-of-an-array-game/description/
 */

public class FindTheWinnerOfAnArrayGame {

    public int getWinner(int[] arr, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(arr.length);
        int max = Integer.MIN_VALUE, min, cnt = 0;
        for (int i : arr) {
            max = Math.max(max, i);
            deque.offer(i);
        }
        if (k >= arr.length) {
            return max;
        }
        int ans = deque.peek();
        while (cnt < k) {
            int first = deque.poll();
            int second = deque.poll();
            max = Math.max(first, second);
            min = Math.min(first, second);
            if (first == max) {
                cnt++;
            } else {
                cnt = 1;
                ans = max;
            }
            deque.offerFirst(max);
            deque.offer(min);
        }
        return ans;
    }

    public int getWinnerV2(int[] arr, int k) {
        int ans = arr[0], cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (ans > arr[i]) {
                cnt++;
            } else {
                ans = arr[i];
                cnt = 1;
            }
            if (cnt == k) {
                return ans;
            }
        }
        return ans;
    }
}

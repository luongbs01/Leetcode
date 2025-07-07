import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
 */

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        int n = events.length, ans = 0, maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/last-stone-weight/description/
 */

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        int first, second;
        while (pq.size() >= 2) {
            first = pq.poll();
            second = pq.poll();
            if (first - second > 0) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
 */

public class SortIntegersByThePowerValue {

    Map<Long, Integer> power = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        power.put(1L, 0);
        for (long i = lo; i <= hi; i++) {
            if (!power.containsKey(i)) {
                compute(i);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (long i = lo; i <= hi; i++) {
            if (pq.size() < k) {
                pq.offer(new int[]{power.get(i), (int) i});
            } else if (pq.peek()[0] > power.get(i)) {
                pq.poll();
                pq.offer(new int[]{power.get(i), (int) i});
            }
        }
        return pq.peek()[1];
    }

    private int compute(long i) {
        if (i == 1) return 0;
        if (power.containsKey(i)) return power.get(i);
        int p = (i & 1) != 0 ? compute(i * 3 + 1) : compute(i >> 1);
        power.put(i, p + 1);
        return p + 1;
    }
}

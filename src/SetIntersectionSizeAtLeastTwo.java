import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/set-intersection-size-at-least-two/description/
 */

public class SetIntersectionSizeAtLeastTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            while (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }
            if (pq.size() < 2 && !set.contains(end)) {
                set.add(end);
                pq.offer(end);
            }
            if (pq.size() < 2 && !set.contains(end - 1)) {
                set.add(end - 1);
                pq.offer(end - 1);
            }
        }
        return set.size();
    }
}

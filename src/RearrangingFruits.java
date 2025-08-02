import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/rearranging-fruits/description/
 */

public class RearrangingFruits {

    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length, min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> freq1 = new HashMap<>(), freq2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq1.put(basket1[i], freq1.getOrDefault(basket1[i], 0) + 1);
            freq2.put(basket2[i], freq2.getOrDefault(basket2[i], 0) + 1);
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int key : freq1.keySet()) {
            min = Math.min(min, key);
            int v1 = freq1.get(key);
            int v2 = freq2.getOrDefault(key, 0);
            if (((v1 + v2) & 1) != 0) {
                return -1;
            } else if (v1 - v2 > 0) {
                v1 = (v1 - v2) >> 1;
                for (int i = 0; i < v1; i++) {
                    pq1.offer(key);
                }
            }
        }
        for (int key : freq2.keySet()) {
            min = Math.min(min, key);
            int v1 = freq1.getOrDefault(key, 0);
            int v2 = freq2.get(key);
            if (((v1 + v2) & 1) != 0) {
                return -1;
            } else if (v2 - v1 > 0) {
                v2 = (v2 - v1) >> 1;
                for (int i = 0; i < v2; i++) {
                    pq2.offer(key);
                }
            }
        }
        long ans = 0;
        while (!pq1.isEmpty()) {
            ans += Math.min(Math.min(pq1.poll(), pq2.poll()), min << 1);
        }
        return ans;
    }
}

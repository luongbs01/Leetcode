import java.util.*;

/**
 * Description: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>(n);
        List<HashMap<Integer, Integer>> cost = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            cost.add(new HashMap<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, src, count});
        while (!queue.isEmpty() && count <= k) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                List<int[]> adj = adjList.get(curr[1]);
                for (int[] v : adj) {
                    if (cost.get(v[0]).getOrDefault(curr[2] + 1, Integer.MAX_VALUE) > cost.get(curr[1]).getOrDefault(curr[2], 0) + v[1]) {
                        cost.get(v[0]).put(curr[2] + 1, cost.get(curr[1]).getOrDefault(curr[2], 0) + v[1]);
                        queue.offer(new int[]{cost.get(v[0]).get(curr[2] + 1), v[0], curr[2] + 1});
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> i : cost.get(dst).entrySet()) {
            if (i.getKey() - 2 < k) {
                ans = Math.min(ans, i.getValue());
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

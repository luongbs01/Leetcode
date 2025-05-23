import java.util.*;

/**
 * Description: https://leetcode.com/problems/network-delay-time/description/
 */

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 0: node, 1: min time
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] time = pq.poll();
            if (visited[time[0]]) {
                continue;
            }
            // MUST set visited here
            visited[time[0]] = true;
            List<int[]> adj = adjList.get(time[0]);
            for (int[] v : adj) { // 0: node, 1: time
                minTime[v[0]] = Math.min(minTime[v[0]], minTime[time[0]] + v[1]);
                if (!visited[v[0]]) {
                    pq.offer(new int[]{v[0], minTime[v[0]]});
                    // DONT set visited here
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, minTime[i]);
        }
        return ans;
    }
}

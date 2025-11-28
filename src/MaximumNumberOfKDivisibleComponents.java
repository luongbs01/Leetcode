import java.util.*;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-k-divisible-components/
 */

public class MaximumNumberOfKDivisibleComponents {

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        long[] lValues = new long[n];
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
            lValues[i] = values[i];
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leafNodes = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leafNodes.offer(i);
            }
        }
        int ans = 1;
        while (!leafNodes.isEmpty()) {
            int leafNode = leafNodes.poll();
            Set<Integer> adj = adjList.get(leafNode);
            if (adj.isEmpty()) continue;
            int parentNode = adj.iterator().next();
            if (lValues[leafNode] % k == 0) {
                ans++;
            } else {
                lValues[parentNode] += lValues[leafNode];
            }
            adjList.get(parentNode).remove(leafNode);
            if (adjList.get(parentNode).size() == 1) {
                leafNodes.offer(parentNode);
            }
        }
        return ans;
    }
}

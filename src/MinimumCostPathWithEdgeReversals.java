import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/
 */

public class MinimumCostPathWithEdgeReversals {

	public int minCost(int n, int[][] edges) {
		int[] minCost = new int[n];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		List<List<int[]>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
			adjList.get(edge[1]).add(new int[] { edge[0], edge[2] << 1 });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		pq.offer(new int[] { 0, 0 }); // costToDest, dest
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			if (arr[0] < minCost[arr[1]]) {
				if (arr[1] == n - 1)
					return arr[0];
				minCost[arr[1]] = arr[0];
				for (int[] adj : adjList.get(arr[1])) {
					if (arr[0] + adj[1] < minCost[adj[0]]) {
						pq.offer(new int[] { arr[0] + adj[1], adj[0] });
					}
				}
			}
		}
		return -1;
	}
}

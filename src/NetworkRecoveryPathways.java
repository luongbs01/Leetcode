import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/network-recovery-pathways/
 */

public class NetworkRecoveryPathways {

	public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
		int n = online.length;
		List<Integer> costs = new ArrayList<>(n);
		costs.add(-1);
		List<List<int[]>> adjList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			if (online[edge[0]] && online[edge[1]] && edge[2] <= k) {
				adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
				costs.add(edge[2]);
			}
		}
		Collections.sort(costs);
		int l = 0, r = costs.size() - 1;
		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (valid(n, adjList, costs.get(mid), k)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return costs.get(l);
	}

	private boolean valid(int n, List<List<int[]>> adjList, int minCost, long k) {
		boolean[] visited = new boolean[n];
		visited[0] = true;
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
		for (int[] adj : adjList.getFirst()) {
			if (adj[1] >= minCost) {
				pq.offer(new long[] { adj[0], adj[1] });
			}
		}
		while (!pq.isEmpty()) {
			long[] head = pq.poll();
			int node = (int) head[0];
			long cost = head[1];
			if (!visited[node]) {
				visited[node] = true;
				if (node == n - 1) {
					return cost <= k;
				}
				for (int[] adj : adjList.get(node)) {
					if (!visited[adj[0]] && adj[1] >= minCost && cost + adj[1] <= k) {
						pq.offer(new long[] { adj[0], cost + adj[1] });
					}
				}
			}
		}
		return false;
	}
}

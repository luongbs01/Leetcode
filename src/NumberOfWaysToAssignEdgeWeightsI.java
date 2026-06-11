import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
 */

public class NumberOfWaysToAssignEdgeWeightsI {

	public int assignEdgeWeights(int[][] edges) {
		int n = edges.length + 1, maxDepth = -1, ans = 1;
		boolean[] visited = new boolean[n + 1];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				for (int adj : adjList.get(node)) {
					if (!visited[adj]) {
						visited[adj] = true;
						queue.offer(adj);
					}
				}
			}
			maxDepth++;
		}
		for (int i = 0; i < maxDepth - 1; i++) {
			ans <<= 1;
			ans %= 1_000_000_007;
		}
		return ans;
	}
}

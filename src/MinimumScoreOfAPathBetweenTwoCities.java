import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 */

public class MinimumScoreOfAPathBetweenTwoCities {

	public int minScore(int n, int[][] roads) {
		boolean[] visited = new boolean[n + 1];
		List<int[]>[] adjList = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] road : roads) {
			adjList[road[0]].add(new int[] { road[1], road[2] });
			adjList[road[1]].add(new int[] { road[0], road[2] });
		}
		int ans = Integer.MAX_VALUE;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (!visited[node]) {
				visited[node] = true;
				for (int[] adj : adjList[node]) {
					if (!visited[adj[0]]) {
						queue.offer(adj[0]);
						ans = Math.min(ans, adj[1]);
					}
				}
			}
		}
		return ans;
	}
}

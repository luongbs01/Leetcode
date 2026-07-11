import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/count-the-number-of-complete-components/
 */

public class CountTheNumberOfCompleteComponents {

	public int countCompleteComponents(int n, int[][] edges) {
		int ans = 0;
		List<Integer>[] adjList = new List[n];
		boolean[] visisted = new boolean[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>(n);
		}
		for (int[] edge : edges) {
			adjList[edge[0]].add(edge[1]);
			adjList[edge[1]].add(edge[0]);
		}
		for (int i = 0; i < n; i++) {
			if (!visisted[i]) {
				Set<Integer> connectedVertices = new HashSet<>();
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				queue.add(i);
				while (!queue.isEmpty()) {
					int v = queue.poll();
					if (!connectedVertices.contains(v)) {
						connectedVertices.add(v);
						visisted[v] = true;
						for (int adj : adjList[v]) {
							if (!connectedVertices.contains(adj)) {
								queue.offer(adj);
							}
						}
					}
				}
				int size = connectedVertices.size() - 1;
				boolean complete = true;
				for (int v : connectedVertices) {
					if (adjList[v].size() != size) {
						complete = false;
						break;
					}
				}
				if (complete) {
					ans++;
				}
			}
		}
		return ans;
	}
}

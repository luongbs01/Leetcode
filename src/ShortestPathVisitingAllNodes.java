import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
 */

public class ShortestPathVisitingAllNodes {

	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		if (n == 1)
			return 0;
		boolean[][] visited = new boolean[n][1 << n];
		Queue<int[]> queue = new ArrayDeque<>(); // [0]: startNode, [1]: mask, [2]: number of steps
		for (int i = 0; i < n; i++) {
			queue.offer(new int[] { i, 1 << i, 0 });
		}
		while (!queue.isEmpty()) {
			int[] head = queue.poll();
			int currNode = head[0], currMask = head[1], steps = head[2];
			if (!visited[currNode][currMask]) {
				visited[currNode][currMask] = true;
				for (int nextNode : graph[currNode]) {
					int nextMask = currMask | (1 << nextNode);

					if (nextMask == (1 << n) - 1) {
						return steps + 1;
					}

					if (!visited[nextNode][nextMask]) {
						queue.offer(new int[] { nextNode, nextMask, steps + 1 });
					}
				}
			}
		}
		return 0;
	}
}

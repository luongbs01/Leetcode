import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/description/
 */

public class MinimizeHammingDistanceAfterSwapOperations {

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int n = source.length, ans = 0;
		List<List<Integer>> adjList = new ArrayList<>(n);
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] swap : allowedSwaps) {
			adjList.get(swap[0]).add(swap[1]);
			adjList.get(swap[1]).add(swap[0]);
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Map<Integer, Integer> cnt = new HashMap<>();
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				queue.offer(i);
				while (!queue.isEmpty()) {
					int index = queue.poll();
					if (visited[index])
						continue;
					visited[index] = true;
					cnt.put(target[index], cnt.getOrDefault(target[index], 0) + 1);
					cnt.put(source[index], cnt.getOrDefault(source[index], 0) - 1);
					for (int j : adjList.get(index)) {
						if (!visited[j]) {
							queue.offer(j);
						}
					}
				}
				for (int j : cnt.values()) {
					if (j > 0) {
						ans += j;
					}
				}
			}
		}
		return ans;
	}
}

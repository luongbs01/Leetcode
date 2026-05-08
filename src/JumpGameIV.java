import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/jump-game-iv/
 */

public class JumpGameIV {

	// 102ms
	public int minJumpsV1(int[] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[] { 0, 0 });
		while (!pq.isEmpty()) {
			int[] head = pq.poll();
			int node = head[0], cost = head[1];
			if (node == n - 1) {
				return cost;
			}
			if (!visited[node]) {
				visited[node] = true;
				if (node > 0 && !visited[node - 1]) {
					pq.offer(new int[] { node - 1, cost + 1 });
				}
				if (node + 1 < n && !visited[node + 1]) {
					pq.offer(new int[] { node + 1, cost + 1 });
				}
				if (map.get(arr[node]).size() > 1 && !set.contains(arr[node])) {
					set.add(arr[node]);
					for (int i : map.get(arr[node])) {
						if (i != node && !visited[i]) {
							pq.offer(new int[] { i, cost + 1 });
						}
					}
				}
			}
		}
		return n - 1;
	}

	// 48ms
	public int minJumpsV2(int[] arr) {
		int n = arr.length, ans = 0;
		boolean[] visited = new boolean[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int cnt = 0; cnt < size; cnt++) {
				int node = queue.poll();
				if (node == n - 1) {
					return ans;
				}
				if (!visited[node]) {
					visited[node] = true;
					if (node > 0 && !visited[node - 1]) {
						queue.offer(node - 1);
					}
					if (node + 1 < n && !visited[node + 1]) {
						queue.offer(node + 1);
					}
					if (map.get(arr[node]).size() > 1 && !set.contains(arr[node])) {
						set.add(arr[node]);
						for (int i : map.get(arr[node])) {
							if (i != node && !visited[i]) {
								queue.offer(i);
							}
						}
					}
				}
			}
			ans++;
		}
		return n - 1;
	}
}

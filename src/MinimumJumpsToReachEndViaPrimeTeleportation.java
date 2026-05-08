import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/
 */

public class MinimumJumpsToReachEndViaPrimeTeleportation {

	public int minJumps(int[] nums) {
		int n = nums.length, ans = 0, max = 0;
		boolean[] visited = new boolean[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}

		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				for (int j = 2; i * j <= max; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
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

					int num = nums[node];
					if (isPrime[num] && !set.contains(num)) {
						set.add(num);
						for (int j = 1; num * j <= max; j++) {
							List<Integer> list = map.get(num * j);
							if (list != null && !list.isEmpty()) {
								for (int k : list) {
									if (k != node) {
										queue.offer(k);
									}
								}
							}
						}
					}
				}
			}
			ans++;
		}
		return ans;
	}
}

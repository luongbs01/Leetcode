import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/remove-methods-from-project/
 */

public class RemoveMethodsFromProject {

	public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
		List<Integer>[] adjList = new List[n];
		boolean[] suspicious = new boolean[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] invocation : invocations) {
			adjList[invocation[0]].add(invocation[1]);
		}
		Queue<Integer> suspiciousMethods = new ArrayDeque<>();
		suspiciousMethods.add(k);
		while (!suspiciousMethods.isEmpty()) {
			int node = suspiciousMethods.poll();
			if (!suspicious[node]) {
				suspicious[node] = true;
				for (int i : adjList[node]) {
					if (!suspicious[i]) {
						suspiciousMethods.offer(i);
					}
				}
			}
		}
		boolean canRemove = true;
		for (int[] invocation : invocations) {
			if (!suspicious[invocation[0]] && suspicious[invocation[1]]) {
				canRemove = false;
				break;
			}
		}
		List<Integer> ans = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			if (!canRemove || !suspicious[i]) {
				ans.add(i);
			}
		}
		return ans;
	}
}

import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/jump-game-iii/
 */

public class JumpGameIII {

	public boolean canReach(int[] arr, int start) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int top = stack.pop();
			visited[top] = true;
			if (top + arr[top] < n && !visited[top + arr[top]]) {
				stack.push(top + arr[top]);
			}
			if (top - arr[top] >= 0 && !visited[top - arr[top]]) {
				stack.push(top - arr[top]);
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0 && visited[i]) {
				return true;
			}
		}
		return false;
	}
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/two-best-non-overlapping-events/description/
 */

public class TwoBestNonOverlappingEvents {

	public int maxTwoEvents(int[][] events) {
		int n = events.length;
		Arrays.sort(events, (o1, o2) -> o1[0] == o2[0] ? o1[2] - o2[2] : o1[0] - o2[0]);
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { events[n - 1][0], events[n - 1][2] });
		for (int i = n - 2; i >= 0; i--) {
			if (events[i][0] < stack.peek()[0]) {
				stack.push(new int[] { events[i][0], Math.max(stack.peek()[1], events[i][2]) });
			}
		}
		int ans = stack.peek()[1];
		Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
		for (int i = 0; i < n && !stack.isEmpty(); i++) {
			while (!stack.isEmpty() && stack.peek()[0] <= events[i][1]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				ans = Math.max(ans, events[i][2] + stack.peek()[1]);
			}
		}
		return ans;
	}
}

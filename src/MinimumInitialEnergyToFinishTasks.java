import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
 */

public class MinimumInitialEnergyToFinishTasks {

	public int minimumEffort(int[][] tasks) {
		Arrays.sort(tasks, (o1, o2) -> o2[1] - o2[0] - o1[1] + o1[0]);
		int l = 0, r = 0;
		for (int[] task : tasks) {
			l += task[0];
			r += task[1];
		}
		while (l < r) {
			int mid = (l + r) >> 1;
			if (valid(tasks, mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	private boolean valid(int[][] tasks, int energy) {
		for (int[] task : tasks) {
			if (energy < task[1]) {
				return false;
			}
			energy -= task[0];
		}
		return energy >= 0;
	}
}

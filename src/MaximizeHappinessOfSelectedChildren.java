import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximize-happiness-of-selected-children/description/
 */

public class MaximizeHappinessOfSelectedChildren {

	public long maximumHappinessSum(int[] happiness, int k) {
		Arrays.sort(happiness);
		long ans = 0;
		for (int i = happiness.length - 1, j = 0; i >= 0 && j < k; i--, j++) {
			ans += Math.max(happiness[i] - j, 0);
		}
		return ans;
	}
}

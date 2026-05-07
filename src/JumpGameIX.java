import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/jump-game-ix/
 */

public class JumpGameIX {

	public int[] maxValue(int[] nums) {
		int n = nums.length;
		int[] prefixMax = new int[n];
		int[] suffixMin = new int[n];
		Arrays.fill(suffixMin, Integer.MAX_VALUE);
		prefixMax[0] = nums[0];
		suffixMin[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
			suffixMin[n - i - 1] = Math.min(suffixMin[n - i], nums[n - i - 1]);
		}
		int[] ans = new int[n];
		ans[n - 1] = prefixMax[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (prefixMax[i] > suffixMin[i + 1]) {
				ans[i] = ans[i + 1];
			} else {
				ans[i] = prefixMax[i];
			}
		}
		return ans;
	}
}

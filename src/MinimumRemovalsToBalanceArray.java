import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-removals-to-balance-array/description/
 */

public class MinimumRemovalsToBalanceArray {

	public int minRemoval(int[] nums, int k) {
		int n = nums.length, ans = 0;
		Arrays.sort(nums);
		int l = 0;
		for (int r = 0; r < n; r++) {
			while (l < r && nums[r] > (long) nums[l] * k) {
				l++;
			}
			ans = Math.max(ans, r - l + 1);
		}
		return n - ans;
	}
}

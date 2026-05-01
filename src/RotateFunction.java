/**
 * Description: https://leetcode.com/problems/rotate-function/description/
 */

public class RotateFunction {

	public int maxRotateFunction(int[] nums) {
		int n = nums.length, ans = Integer.MIN_VALUE, f = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			f += i * nums[i];
		}
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, f);
			f = f + sum - n * nums[n - i - 1];
		}
		return Math.max(ans, f);
	}
}

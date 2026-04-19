/**
 * Description: https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
 */

public class ApplyOperationsToMakeAllArrayElementsEqualToZero {

	public boolean checkArray(int[] nums, int k) {
		int n = nums.length, curr = 0;
		int[] diff = new int[n + 1];
		diff[0] = nums[0];
		diff[n] = -nums[n - 1];
		for (int i = 1; i < n; i++) {
			diff[i] = nums[i] - nums[i - 1];
		}
		for (int i = 0; i < n; i++) {
			curr += diff[i];
			if (curr < 0 || (curr > 0 && (i + k > n))) {
				return false;
			} else if (i + k <= n) {
				diff[i + k] += curr;
				curr = 0;
			}
		}
		return true;
	}
}

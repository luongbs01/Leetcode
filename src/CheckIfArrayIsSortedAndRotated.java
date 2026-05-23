/**
 * Description: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */

public class CheckIfArrayIsSortedAndRotated {

	public boolean check(int[] nums) {
		int n = nums.length, cnt = nums[n - 1] > nums[0] ? 1 : 0;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] > nums[i]) {
				cnt++;
			}
			if (cnt > 1) {
				return false;
			}
		}
		return true;
	}
}

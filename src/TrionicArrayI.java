/**
 * Description: https://leetcode.com/problems/trionic-array-i/description/
 */

public class TrionicArrayI {

	public boolean isTrionic(int[] nums) {
		int n = nums.length, sign = 1, cnt = 0;
		if (n < 4 || nums[0] >= nums[1]) {
			return false;
		}
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] == nums[i]) {
				return false;
			} else if ((nums[i] - nums[i - 1]) * sign < 0) {
				sign = -sign;
				cnt++;
			}
		}
		return cnt == 2;
	}
}

/**
 * Description: https://leetcode.com/problems/minimum-distance-to-the-target-element/description/
 */

public class MinimumDistanceToTheTargetElement {

	public int getMinDistance(int[] nums, int target, int start) {
		int n = nums.length, ans = n;
		for (int i = 0; i < n; i++) {
			if (nums[i] == target) {
				ans = Math.min(ans, Math.abs(i - start));
			}
		}
		return ans;
	}
}

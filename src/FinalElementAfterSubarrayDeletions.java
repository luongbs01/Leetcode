/**
 * Description: https://leetcode.com/problems/final-element-after-subarray-deletions/description/
 */

public class FinalElementAfterSubarrayDeletions {

	public int finalElement(int[] nums) {
		return Math.max(nums[0], nums[nums.length - 1]);
	}
}

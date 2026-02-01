import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 */

public class DivideAnArrayIntoSubarraysWithMinimumCostI {

	public int minimumCost(int[] nums) {
		int n = nums.length, ans = nums[0] + nums[1] + nums[2], min = nums[1];
		for (int i = 3; i < n; i++) {
			min = Math.min(min, nums[i - 1]);
			ans = Math.min(ans, nums[0] + min + nums[i]);
		}
		return ans;
	}
}

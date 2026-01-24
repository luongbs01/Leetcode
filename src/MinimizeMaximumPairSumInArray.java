import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 */

public class MinimizeMaximumPairSumInArray {

	public int minPairSum(int[] nums) {
		int n = nums.length, ans = Integer.MIN_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < n / 2; i++) {
			ans = Math.max(ans, nums[i] + nums[n - i - 1]);
		}
		return ans;
	}
}

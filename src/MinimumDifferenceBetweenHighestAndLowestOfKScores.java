import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 */

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

	public int minimumDifference(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length, ans = Integer.MAX_VALUE;
		for (int i = k - 1; i < n; i++) {
			ans = Math.min(ans, nums[i] - nums[i - k + 1]);
		}
		return ans;
	}
}

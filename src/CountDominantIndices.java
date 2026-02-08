/**
 * Description: https://leetcode.com/problems/count-dominant-indices/description/
 */

public class CountDominantIndices {

	public int dominantIndices(int[] nums) {
		int ans = 0, n = nums.length, sum = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > sum / (n - 1 - i)) {
				ans++;
			}
			sum += nums[i];
		}
		return ans;
	}
}

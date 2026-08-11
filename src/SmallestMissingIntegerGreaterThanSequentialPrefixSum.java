/**
 * Description: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
 */

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {

	public int missingInteger(int[] nums) {
		int n = nums.length, sum = nums[0];
		boolean[] seen = new boolean[51];
		for (int num : nums) {
			seen[num] = true;
		}
		for (int i = 1; i < n && nums[i] == nums[i - 1] + 1; i++) {
			sum += nums[i];
		}
		int ans = sum;
		while (ans < seen.length && seen[ans]) {
			ans++;
		}
		return ans;
	}
}

/**
 * Description: https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
 */

public class CountSubarraysWithMajorityElementII {

	public long countMajoritySubarrays(int[] nums, int target) {
		int n = nums.length;
		long ans = 0, valid = 0;
		int[] prefixSum = new int[n + 1];
		int[] cnt = new int[2 * n + 1];
		cnt[n] = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = (nums[i] == target ? 1 : -1);
			prefixSum[i + 1] = prefixSum[i] + nums[i];

			if (nums[i] > 0) {
				valid += cnt[prefixSum[i] + n];
			} else {
				valid -= cnt[prefixSum[i + 1] + n];
			}
			ans += valid;
			cnt[prefixSum[i + 1] + n]++;
		}
		return ans;
	}
}

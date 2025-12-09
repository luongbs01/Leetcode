/**
 * Description: https://leetcode.com/problems/count-special-triplets/description/
 */

public class CountSpecialTriplets {

	public int specialTriplets(int[] nums) {
		int n = nums.length, mod = 1_000_000_007, max = 100_001;
		int[] lCount = new int[max];
		int[] rCount = new int[max];
		lCount[nums[0]]++;
		for (int i = 2; i < n; i++) {
			rCount[nums[i]]++;
		}
		long ans = 0;
		for (int i = 1; i < n - 1; i++) {
			if ((nums[i] << 1) < max) {
				ans = (ans + (long) lCount[nums[i] << 1] * rCount[nums[i] << 1]) % mod;
			}
			lCount[nums[i]]++;
			rCount[nums[i + 1]]--;
		}
		return (int) ans;
	}
}

/**
 * Description: https://leetcode.com/problems/count-subarrays-with-majority-element-i/
 */

public class CountSubarraysWithMajorityElementI {

	public int countMajoritySubarrays(int[] nums, int target) {
		int n = nums.length, ans = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = i; j < n; j++) {
				if (nums[j] == target) {
					cnt++;
				}
				if ((cnt << 1) > (j - i + 1)) {
					ans++;
				}
			}
		}
		return ans;
	}
}

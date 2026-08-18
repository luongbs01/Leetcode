/**
 * Description: https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/
 */

public class FindTheLargestAlmostMissingInteger {

	public int largestInteger(int[] nums, int k) {
		int n = nums.length, ans = -1;
		int[] freq = new int[51];
		boolean[] seen = new boolean[51];
		for (int start = 0; start + k <= n; start++) {
			for (int i = start; i < start + k; i++) {
				seen[nums[i]] = true;
			}
			for (int i = 50; i >= 0; i--) {
				if (seen[i]) {
					freq[i]++;
					seen[i] = false;
				}
			}
		}
		for (int i = 50; i >= 0; i--) {
			if (freq[i] == 1) {
				ans = i;
				break;
			}
		}
		return ans;
	}
}

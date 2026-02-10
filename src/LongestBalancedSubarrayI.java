import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/longest-balanced-subarray-i/
 */

public class LongestBalancedSubarrayI {

	public int longestBalanced(int[] nums) {
		int n = nums.length, ans = 0;
		Set<Integer> odd = new HashSet<>();
		Set<Integer> even = new HashSet<>();
		for (int i = 0; i < n; i++) {
			odd.clear();
			even.clear();
			for (int j = i; j < n; j++) {
				if ((nums[j] & 1) != 0) {
					odd.add(nums[j]);
				} else {
					even.add(nums[j]);
				}
				if (odd.size() == even.size()) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
	}
}

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
 */

public class MinimumAbsoluteDistanceBetweenMirrorPairs {

	public int minMirrorPairDistance(int[] nums) {
		int n = nums.length, ans = Integer.MAX_VALUE;
		Map<Integer, Integer> lastSeen = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (lastSeen.containsKey(nums[i])) {
				ans = Math.min(ans, i - lastSeen.get(nums[i]));
			}
			lastSeen.put(reverse(nums[i]), i);
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	private int reverse(int n) {
		int ans = 0;
		while (n > 0) {
			ans = (ans * 10 + n % 10);
			n /= 10;
		}
		return ans;
	}
}

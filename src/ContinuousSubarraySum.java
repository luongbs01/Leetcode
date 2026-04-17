import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/continuous-subarray-sum/
 */

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		int n = nums.length;
		long r = 0;
		HashMap<Long, Integer> firstOccurrence = new HashMap<>();
		firstOccurrence.put(0L, -1);
		for (int i = 0; i < n; i++) {
			r = (r + nums[i] % k) % k;
			if (firstOccurrence.containsKey(r)) {
				if (i - firstOccurrence.get(r) >= 2) {
					return true;
				}
			} else {
				firstOccurrence.put(r, i);
			}
		}
		return false;
	}
}

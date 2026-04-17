import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/subarray-sum-equals-k/
 */

public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int ans = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int num : nums) {
			sum += num;
			ans += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}
}

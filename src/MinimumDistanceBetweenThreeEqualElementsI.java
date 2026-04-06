import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/
 */

public class MinimumDistanceBetweenThreeEqualElementsI {

	public int minimumDistance(int[] nums) {
		int n = nums.length, ans = Integer.MAX_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			List<Integer> value = e.getValue();
			if (value.size() > 2) {
				for (int i = 0; i < value.size() - 2; i++) {
					ans = Math.min(ans, value.get(i + 2) - value.get(i));
				}
			}
		}
		return ans == Integer.MAX_VALUE ? -1 : ans << 1;
	}
}

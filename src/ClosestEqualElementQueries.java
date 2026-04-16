import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/closest-equal-element-queries/description/
 */

public class ClosestEqualElementQueries {

	public List<Integer> solveQueries(int[] nums, int[] queries) {
		int n = nums.length;
		int[] minDist = new int[n];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		Map<Integer, Integer> lastSeen = new HashMap<>();
		for (int i = 0; i <= (n + n / 2); i++) {
			Integer index = lastSeen.get(nums[i % n]);
			if (index == null) {
				lastSeen.put(nums[i % n], i);
			} else if ((index % n) != (i % n)) {
				int dist = Math.abs(i - index);
				minDist[i % n] = Math.min(minDist[i % n], dist);
				minDist[index % n] = Math.min(minDist[index % n], dist);
				lastSeen.put(nums[i % n], i);
			}
		}
		List<Integer> ans = new ArrayList<>(queries.length);
		for (int query : queries) {
			ans.add(minDist[query] == Integer.MAX_VALUE ? -1 : minDist[query]);
		}
		return ans;
	}
}

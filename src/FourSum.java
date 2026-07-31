import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/4sum/
 */

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums.length < 4)
			return Collections.emptyList();
		int n = 0;
		Set<List<Integer>> ans = new HashSet<>();
		Map<Integer, Integer> freq = new HashMap<>();
		for (int i : nums) {
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			for (int i = 0; i < Math.min(entry.getValue(), 4); i++) {
				nums[n++] = entry.getKey();
			}
		}
		Map<Long, List<List<Integer>>> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				long sum = nums[i] + nums[j];
				map.putIfAbsent(sum, new ArrayList<>());
				map.get(sum).add(List.of(i, j));
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				long sum = nums[i] + nums[j];
				if (map.containsKey(target - sum)) {
					for (List<Integer> list : map.get(target - sum)) {
						if (i != list.get(0) && j != list.get(0) && i != list.get(1) && j != list.get(1)) {
							List<Integer> sorted = Arrays.asList(nums[i], nums[j], nums[list.get(0)], nums[list.get(1)]);
							Collections.sort(sorted);
							ans.add(sorted);
						}
					}
				}
			}
		}
		return ans.parallelStream().toList();
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/sum-of-distances/
 */

public class SumOfDistances {

	public long[] distance(int[] nums) {
		int n = nums.length;
		long[] ans = new long[n];
		Map<Integer, List<Integer>> occurence = new HashMap<>();
		for (int i = 0; i < n; i++) {
			occurence.computeIfAbsent(nums[i], (k) -> new ArrayList<>()).add(i);
		}
		for (List<Integer> arr : occurence.values()) {
			int size = arr.size();
			if (size == 1) {
				ans[arr.getFirst()] = 0;
				continue;
			}
			long[] prefixSum = new long[size + 1];
			for (int i = 1; i <= size; i++) {
				prefixSum[i] = prefixSum[i - 1] + arr.get(i - 1);
			}
			for (int i = 0; i < size; i++) {
				ans[arr.get(i)] = prefixSum[size] - prefixSum[i + 1] - prefixSum[i] + arr.get(i) * (2L * i - size + 1);
			}
		}
		return ans;
	}
}

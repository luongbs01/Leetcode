import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/intervals-between-identical-elements/description/
 */

public class IntervalsBetweenIdenticalElements {

	public long[] getDistances(int[] arr) {
		int n = arr.length;
		long[] ans = new long[n];
		Map<Integer, List<Integer>> occurence = new HashMap<>();
		for (int i = 0; i < n; i++) {
			occurence.computeIfAbsent(arr[i], (k) -> new ArrayList<>()).add(i);
		}
		for (List<Integer> list : occurence.values()) {
			int size = list.size();
			if (size == 1) {
				ans[list.getFirst()] = 0;
				continue;
			}
			long[] prefixSum = new long[size + 1];
			for (int i = 1; i <= size; i++) {
				prefixSum[i] = prefixSum[i - 1] + list.get(i - 1);
			}
			for (int i = 0; i < size; i++) {
				ans[list.get(i)] = prefixSum[size] - prefixSum[i + 1] - prefixSum[i] + list.get(i) * (2L * i - size + 1);
			}
		}
		return ans;
	}
}

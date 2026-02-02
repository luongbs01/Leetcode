import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/
 */

public class DivideAnArrayIntoSubarraysWithMinimumCostII {

	public long minimumCost(int[] nums, int k, int dist) {
		int n = nums.length, maxUsing, minWaiting;
		Long ans, minSum = 0L;
		TreeSet<Integer> using = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2]);
		TreeSet<Integer> waiting = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2]);

		for (int i = 1; i <= dist + 1; i++) {
			using.add(i);
			minSum += nums[i];
		}
		while (using.size() >= k) {
			int idxOfMax = using.pollLast();
			minSum -= nums[idxOfMax];
			waiting.add(idxOfMax);
		}
		ans = minSum;

		for (int i = 2; i + dist < n; i++) {
			if (using.contains(i - 1)) {
				using.remove(i - 1);
				minSum -= nums[i - 1];
				using.add(i + dist);
				minSum += nums[i + dist];
			} else {
				waiting.remove(i - 1);
				waiting.add(i + dist);
			}

			if (!waiting.isEmpty()) {
				maxUsing = using.last();
				minWaiting = waiting.first();
				while (nums[maxUsing] > nums[minWaiting]) {
					using.pollLast();
					minSum -= nums[maxUsing];
					waiting.add(maxUsing);

					using.add(minWaiting);
					minSum += nums[minWaiting];
					waiting.pollFirst();

					maxUsing = using.last();
					minWaiting = waiting.first();
				}
			}

			ans = Math.min(ans, minSum);
		}

		return ans + nums[0];
	}
}

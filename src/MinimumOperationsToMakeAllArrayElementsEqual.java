import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/
 */

public class MinimumOperationsToMakeAllArrayElementsEqual {

	public List<Long> minOperations(int[] nums, int[] queries) {
		int n = nums.length, m = queries.length;
		Arrays.sort(nums);
		long[] prefixSum = new long[n];
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		List<Long> ans = new ArrayList<>(m);
		for (int query : queries) {
			if (query < nums[0]) {
				ans.add(prefixSum[n - 1] - n * (long) query);
			} else if (query > nums[n - 1]) {
				ans.add(n * (long) query - prefixSum[n - 1]);
			} else {
				int l = 0, r = n - 1;
				while (l < r) {
					int mid = (l + r + 1) >> 1;
					if (nums[mid] > query) {
						r = mid - 1;
					} else {
						l = mid;
					}
				}
				// (l + 1) - (n - (l+1)) => 2l - n + 2
				ans.add(prefixSum[n - 1] - 2 * prefixSum[l] + (long) query * (2 * l - n + 2));
			}
		}
		return ans;
	}
}

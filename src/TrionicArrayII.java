/**
 * Description: https://leetcode.com/problems/transformed-array-ii/description/
 */

public class TrionicArrayII {

	public long maxSumTrionic(int[] nums) {
		int n = nums.length, l = 0;
		long MIN_VALUE = (long) -1E15, ans = MIN_VALUE;
		while (l + 3 < n) {
			long sum = 0, max = MIN_VALUE, prefixSum = 0;
			int p = l + 1;
			if (nums[l] >= nums[p]) {
				l++;
				continue;
			}
			while (p + 1 < n && nums[p] < nums[p + 1]) {
				p++;
			}

			int q = p + 1;
			if (q >= n || nums[q - 1] == nums[q]) {
				l = q;
				continue;
			}
			while (q + 1 < n && nums[q] > nums[q + 1]) {
				q++;
			}

			int r = q + 1;
			if (r >= n || nums[r - 1] == nums[r]) {
				l = r;
				continue;
			}
			while (r + 1 < n && nums[r] < nums[r + 1]) {
				r++;
			}

			for (int i = p; i <= q; i++) {
				sum += nums[i];
			}

			for (int i = p - 1; i >= l; i--) {
				prefixSum += nums[i];
				max = Math.max(max, prefixSum);
			}
			sum += max;

			max = MIN_VALUE;
			prefixSum = 0;
			for (int i = q + 1; i <= r; i++) {
				prefixSum += nums[i];
				max = Math.max(max, prefixSum);
			}
			sum += max;

			ans = Math.max(ans, sum);
			l = q;
		}
		return ans;
	}
}

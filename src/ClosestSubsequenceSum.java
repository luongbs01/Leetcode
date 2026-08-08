import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/closest-subsequence-sum/
 */

public class ClosestSubsequenceSum {

	public int minAbsDifference(int[] nums, int goal) {
		int n = nums.length, ans = Integer.MAX_VALUE;
		if (n == 1)
			return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
		int[] leftPart = process(nums, 0, n / 2);
		int[] rightPart = process(nums, n / 2, n);
		for (int i : leftPart) {
			int target = goal - i, l = 0, r = rightPart.length - 1, mid;
			while (r - l > 1) {
				mid = (l + r) >> 1;
				if (rightPart[mid] == target) {
					l = r = mid;
				} else if (rightPart[mid] < target) {
					l = mid;
				} else {
					r = mid;
				}
			}
			ans = Math.min(ans, Math.abs(i + rightPart[l] - goal));
			ans = Math.min(ans, Math.abs(i + rightPart[r] - goal));
		}
		return ans;
	}

	private int[] process(int[] nums, int l, int r) {
		int n = r - l, idx = 0;
		Set<Integer> set = new HashSet<>();
		set.add(0);
		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (((1 << j) & i) != 0) {
					sum += nums[l + j];
				}
			}
			set.add(sum);
		}
		n = set.size();
		int[] arr = new int[n];
		for (int i : set) {
			arr[idx++] = i;
		}
		Arrays.sort(arr);
		return arr;
	}
}

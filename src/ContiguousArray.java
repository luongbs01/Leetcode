import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/contiguous-array/
 */

public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		int n = nums.length, sum = 0, ans = 0;
		int[] firstOccurrence = new int[(n << 1) | 1];
		Arrays.fill(firstOccurrence, -2);
		firstOccurrence[n] = -1;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				sum++;
			} else {
				sum--;
			}
			if (firstOccurrence[sum + n] != -2) {
				ans = Math.max(ans, i - firstOccurrence[sum + n]);
			} else {
				firstOccurrence[sum + n] = i;
			}
		}
		return ans;
	}
}

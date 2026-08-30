/**
 * Description: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */

public class RemovingMinimumAndMaximumFromArray {

	public int minimumDeletions(int[] nums) {
		int n = nums.length, minIdx = 0, maxIdx = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] < nums[minIdx]) {
				minIdx = i;
			}
			if (nums[i] > nums[maxIdx]) {
				maxIdx = i;
			}
		}
		if (minIdx > maxIdx) {
			int temp = minIdx;
			minIdx = maxIdx;
			maxIdx = temp;
		}
		return Math.min(minIdx + 1 + n - maxIdx, Math.min(maxIdx + 1, n - minIdx));
	}
}

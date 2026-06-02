/**
 * Description: https://leetcode.com/problems/sort-an-array/
 */

public class SortAnArray {

	public int[] sortArray(int[] nums) {
		int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, idx = 0;
		int[] ans = new int[n];
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int[] cnt = new int[max - min + 1];
		for (int i : nums) {
			cnt[i - min]++;
		}
		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i]-- > 0) {
				ans[idx++] = i + min;
			}
		}
		return ans;
	}
}

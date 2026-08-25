/**
 * Description: https://leetcode.com/problems/smallest-missing-multiple-of-k/
 */

public class SmallestMissingMultipleOfK {

	public int missingMultiple(int[] nums, int k) {
		int i = 1;
		boolean[] seen = new boolean[101];
		for (int num : nums) {
			seen[num] = true;
		}
		while (i * k <= 100 && seen[i * k]) {
			i++;
		}
		return i * k;
	}
}

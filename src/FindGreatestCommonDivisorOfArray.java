/**
 * Description: https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/
 */

public class FindGreatestCommonDivisorOfArray {

	public int findGCD(int[] nums) {
		int min = 1000, max = 0;
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		while (min != 0) {
			int t = max % min;
			max = min;
			min = t;
		}
		return max;
	}
}

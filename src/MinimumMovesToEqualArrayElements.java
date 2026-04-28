/**
 * Description: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */

public class MinimumMovesToEqualArrayElements {

	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE, ans = 0;
		for (int num : nums) {
			min = Math.min(min, num);
		}
		for (int num : nums) {
			ans += (num - min);
		}
		return ans;
	}
}

/**
 * Description: https://leetcode.com/problems/concatenation-of-array/description/
 */

public class ConcatenationOfArray {

	public int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n << 1];
		for (int i = 0; i < n; i++) {
			ans[i] = ans[i + n] = nums[i];
		}
		return ans;
	}
}

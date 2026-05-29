/**
 * Description: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
 */

public class MinimumElementAfterReplacementWithDigitSum {

	public int minElement(int[] nums) {
		int ans = 100;
		for (int num : nums) {
			int sum = 0;
			while (num != 0 && sum < ans) {
				sum += num % 10;
				num /= 10;
			}
			ans = Math.min(ans, sum);
		}
		return ans;
	}
}

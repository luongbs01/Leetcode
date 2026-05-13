/**
 * Description: https://leetcode.com/problems/minimum-moves-to-make-array-complementary/
 */

public class MinimumMovesToMakeArrayComplementary {

	public int minMoves(int[] nums, int limit) {
		int n = nums.length, ans = Integer.MAX_VALUE, currOps = 0;
		int[] diff = new int[2 * limit + 2];
		for (int i = 0; i < n / 2; i++) {
			int min = Math.min(nums[i], nums[n - 1 - i]);
			int max = Math.max(nums[i], nums[n - 1 - i]);
			diff[2] += 2;
			diff[min + 1]--;
			diff[min + max]--;
			diff[min + max + 1]++;
			diff[max + limit + 1] += 1;
		}
		for (int i = 2; i <= 2 * limit; i++) {
			currOps += diff[i];
			ans = Math.min(ans, currOps);
		}
		return ans;
	}
}

/**
 * Description: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 */

public class SumOfAbsoluteDifferencesInASortedArray {

	public int[] getSumAbsoluteDifferences(int[] nums) {
		int n = nums.length;
		int[] prefixSum = new int[n + 1];
		int[] ans = new int[n];
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < n; i++) {
			ans[i] = prefixSum[n] - prefixSum[i + 1] - prefixSum[i] + nums[i] * (2 * i - n + 1);
		}
		return ans;
	}
}

/**
 * Description: https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/description/
 */

public class MinimumCostToEqualizeArraysUsingSwaps {

	public int minCost(int[] nums1, int[] nums2) {
		int n = nums1.length, max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, Math.max(nums1[i], nums2[2]));
		}
		int[] freq1 = new int[max + 1];
		int[] freq2 = new int[max + 1];
		for (int i = 0; i < n; i++) {
			freq1[nums1[i]]++;
			freq2[nums2[i]]++;
		}
		int ans = 0;
		for (int i = 0; i <= max; i++) {
			if (freq1[i] > 0 || freq2[i] > 0) {
				if ((freq1[i] + freq2[i]) % 2 != 0) {
					return -1;
				} else {
					ans += Math.abs(freq1[i] - freq2[i]) % 2;
				}
			}
		}
		return ans / 2;
	}
}

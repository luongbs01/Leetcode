/**
 * Description: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 */

public class MaximumDistanceBetweenAPairOfValues {

	public int maxDistance(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length, ans = 0, j = 0;
		for (int i = 0; i < n1; i++) {
			j = Math.max(j, i);
			while (j < n2 && nums1[i] <= nums2[j]) {
				ans = Math.max(ans, j - i);
				j++;
			}
		}
		return ans;
	}
}

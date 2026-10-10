/**
 * Description: https://leetcode.com/problems/minimum-sum-of-squared-difference/
 */

public class MinimumSumOfSquaredDifference {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1 + k2, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.abs(nums1[i] - nums2[i]));
        }
        int[] freq = new int[max + 1];
        for (int i = 0; i < n; i++) {
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }
        for (int i = max; i > 0 && k > 0; i--) {
            int diff = Math.min(k, freq[i]);
            k -= diff;
            freq[i] -= diff;
            freq[i - 1] += diff;
        }

        long ans = 0;
        for (int i = max; i > 0; i--) {
            ans += (long) freq[i] * i * i;
        }
        return ans;
    }
}

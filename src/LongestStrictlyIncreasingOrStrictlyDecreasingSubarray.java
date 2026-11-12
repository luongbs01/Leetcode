/**
 * Description: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 */

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, inc = 1, dec = 1, maxInc = 1, maxDec = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                maxInc = Math.max(maxInc, inc);
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                maxDec = Math.max(maxDec, dec);
                inc = 1;
            } else {
                inc = dec = 1;
            }
        }
        return Math.max(maxInc, maxDec);
    }
}

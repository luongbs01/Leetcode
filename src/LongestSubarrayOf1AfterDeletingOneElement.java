/**
 * Description: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 */

public class LongestSubarrayOf1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int n = nums.length, last = 0, curr = 0, ans = 0;
        for (int num : nums) {
            if (num == 0) {
                last = curr;
                curr = 0;
            } else {
                curr++;
                ans = Math.max(ans, curr + last);
            }
        }
        return ans == n ? n - 1 : ans;
    }
}

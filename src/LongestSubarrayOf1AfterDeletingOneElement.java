/**
 * Description: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 */

public class LongestSubarrayOf1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int n = nums.length, last = 0, curr = 0, countZero = 0, ans = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
                last = countZero > 1 ? 0 : curr;
                curr = 0;
            } else {
                countZero = 0;
                curr++;
                ans = Math.max(ans, curr + last);
            }
        }
        return ans == n ? n - 1 : ans;
    }
}

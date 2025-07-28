/**
 * Description: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/
 */

public class LongestSubarrayWithMaximumBitwiseAND {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int cnt = 1, ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] && max == nums[i]) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}

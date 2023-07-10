/**
 * Description: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lisEndingAt = new int[n];
        lisEndingAt[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, lisEndingAt[j]);
                }
            }
            lisEndingAt[i] = Math.max(1, max + 1);
            ans = Math.max(ans, lisEndingAt[i]);
        }
        return ans;
    }
}

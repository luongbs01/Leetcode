/**
 * Description: https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxProductEndingAt = new int[n];
        int[] minProductEndingAt = new int[n];
        if (nums[0] != 0) {
            maxProductEndingAt[0] = minProductEndingAt[0] = nums[0];
        } else {
            maxProductEndingAt[0] = minProductEndingAt[0] = 0;
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                maxProductEndingAt[i] = Math.max(maxProductEndingAt[i - 1] * nums[i], nums[i]);
                minProductEndingAt[i] = Math.min(minProductEndingAt[i - 1] * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                maxProductEndingAt[i] = Math.max(minProductEndingAt[i - 1] * nums[i], nums[i]);
                minProductEndingAt[i] = Math.min(maxProductEndingAt[i - 1] * nums[i], nums[i]);
            } else {
                maxProductEndingAt[i] = minProductEndingAt[i] = 0;
            }
            ans = Math.max(ans, maxProductEndingAt[i]);
        }
        return ans;
    }
}

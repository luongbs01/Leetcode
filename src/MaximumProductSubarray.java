/**
 * Description: https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] minNegative = new int[length];
        int[] maxPositive = new int[length];
        int ans = nums[0];
        if (nums[0] > 0) {
            maxPositive[0] = nums[0];
        } else {
            minNegative[0] = nums[0];
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                minNegative[i] = minNegative[i - 1] * nums[i];
                maxPositive[i] = Math.max(nums[i], maxPositive[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                minNegative[i] = Math.min(nums[i], maxPositive[i - 1] * nums[i]);
                maxPositive[i] = minNegative[i - 1] * nums[i];
            }
            ans = Math.max(ans, maxPositive[i]);
        }
        return ans;
    }
}

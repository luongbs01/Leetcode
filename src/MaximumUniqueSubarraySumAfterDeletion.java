import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
 */

public class MaximumUniqueSubarraySumAfterDeletion {

    public int maxSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[n - 1] <= 0) {
            return nums[n - 1];
        }
        int ans = nums[n - 1];
        int i = n - 2;
        while (i >= 0 && nums[i] > 0) {
            if (nums[i] < nums[i + 1]) {
                ans += nums[i];
            }
            i--;
        }
        return ans;
    }
}

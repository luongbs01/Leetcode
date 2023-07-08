/**
 * Description: https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = nums[0], count = 1;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        while (right < len) {
            while (sum < target) {
                right++;
                if (right < len) {
                    sum += nums[right];
                    count++;
                } else break;
            }
            if (sum >= target) min = Math.min(count, min);
            while (sum >= target && right >= left) {
                min = Math.min(count, min);
                sum -= nums[left];
                left++;
                count--;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

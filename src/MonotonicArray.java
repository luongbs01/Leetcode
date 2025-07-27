/**
 * Description: https://leetcode.com/problems/monotonic-array/description/
 */

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int sign = nums[0] > nums[n - 1] ? 1 : -1;
        for (int i = 1; i < n; i++) {
            if ((nums[i - 1] - nums[i]) * sign < 0) {
                return false;
            }
        }
        return true;
    }
}

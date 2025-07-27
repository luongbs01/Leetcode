/**
 * Description: https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/
 */

public class CountHillsAndValleysInAnArray {

    public int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        int j = i < n - 1 && nums[i] > nums[i + 1] ? 1 : -1;
        int ans = -1;
        while (i < n - 1) {
            if ((nums[i] - nums[i + 1]) * j > 0) {
                ans++;
                j = -j;
            }
            i++;
        }
        return Math.max(ans, 0);
    }
}

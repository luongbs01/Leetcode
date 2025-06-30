/**
 * Description: https://leetcode.com/problems/first-missing-positive/description/
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            while (value >= 1 && value <= n && nums[value - 1] != value) {
                int temp = nums[value - 1];
                nums[value - 1] = value;
                value = temp;
            }
        }
        int ans = 1;
        for (int num : nums) {
            if (num == ans) {
                ans++;
            }
        }
        return ans;
    }
}

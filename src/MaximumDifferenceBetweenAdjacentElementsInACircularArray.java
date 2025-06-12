/**
 * Description: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/
 */


public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {

    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        return ans;
    }
}

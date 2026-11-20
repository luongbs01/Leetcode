import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-score-by-changing-two-elements/
 */

public class MinimumScoreByChangingTwoElements {

    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.min(Math.min(nums[n - 3] - nums[0], nums[n - 1] - nums[2]), nums[n - 2] - nums[1]);
    }
}

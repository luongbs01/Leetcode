import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/house-robber-ii/description/
 */

public class HouseRobberII {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robForRange(Arrays.copyOfRange(nums, 0, length - 1)),
                robForRange(Arrays.copyOfRange(nums, 1, length)));
    }

    public int robForRange(int[] nums) {
        int length = nums.length;
        if (length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}

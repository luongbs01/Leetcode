/**
 * Description: https://leetcode.com/problems/left-and-right-sum-differences/description/
 */

public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length, rightSum = 0;
        int[] leftSum = new int[n], ans = new int[n];
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        ans[n - 1] = Math.abs(leftSum[n - 1] - rightSum);
        for (int i = n - 2; i >= 0; i--) {
            rightSum += nums[i + 1];
            ans[i] = Math.abs(leftSum[i] - rightSum);
        }
        return ans;
    }
}

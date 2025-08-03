/**
 * Description: https://leetcode.com/problems/left-and-right-sum-differences/description/
 */

public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n], rightSum = new int[n], ans = new int[n];
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        rightSum[n - 1] = 0;
        ans[n - 1] = Math.abs(leftSum[n - 1] - rightSum[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}

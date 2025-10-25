/**
 * Description: https://leetcode.com/problems/make-array-elements-equal-to-zero/
 */

public class MakeArrayElementsEqualToZero {

    public int countValidSelections(int[] nums) {
        int n = nums.length, ans = 0, sum = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (nums[i] == 0) {
                if (sum == prefixSum[i]) ans += 2;
                else if (Math.abs(sum - prefixSum[i]) == 1) ans++;
            }
        }
        return ans;
    }
}

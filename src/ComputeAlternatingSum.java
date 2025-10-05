/**
 * Description: https://leetcode.com/problems/compute-alternating-sum/description/
 */

public class ComputeAlternatingSum {

    public int alternatingSum(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            ans = i % 2 == 0 ? ans + nums[i] : ans - nums[i];
        }
        return ans;
    }
}

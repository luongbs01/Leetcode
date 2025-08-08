/**
 * Description: https://leetcode.com/problems/sum-of-subarray-ranges/description/
 */

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }
}

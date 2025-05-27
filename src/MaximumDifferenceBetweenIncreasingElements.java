/**
 * Description: https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
 */

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            ans = Math.max(ans, num - min);
        }
        return ans > 0 ? ans : -1;
    }
}

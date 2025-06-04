/**
 * Description: https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int countZero = 0;
        int ans = 0;
        while (r < n) {
            while (r < n && countZero <= k) {
                if (nums[r] == 0) {
                    countZero++;
                }
                r++;
            }
            ans = countZero <= k ? Math.max(ans, r - l) : Math.max(ans, r - l - 1);
            while (countZero > k && l < r) {
                if (nums[l] == 0) {
                    countZero--;
                }
                l++;
            }
        }
        return ans;
    }
}

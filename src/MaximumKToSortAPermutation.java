/**
 * Description: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
 */

public class MaximumKToSortAPermutation {

    // wrong answer
    public int sortPermutation(int[] nums) {
        int n = nums.length, ans = -1;
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                ans = ans & nums[i];
            }
        }
        return Math.max(ans, 0);
    }
}

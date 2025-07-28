/**
 * Description: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/
 */

public class CountNumberOfMaximumBitwiseORSubsets {

    int max = 0;
    int ans = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0, 0);
        dfs(nums, 0, 0, 1);
        return ans;
    }

    private void dfs(int[] nums, int index, int res, int flag) {
        if (index < nums.length) {
            if (flag == 1 && (res | nums[index]) > max) {
                max = res | nums[index];
                ans = 1;
            } else if (flag == 1 && (res | nums[index]) == max) {
                ans++;
            }
            for (int i = 0; i < 2; i++) {
                dfs(nums, index + 1, flag == 1 ? res | nums[index] : res, i);
            }
        }
    }
}

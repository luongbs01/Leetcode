/**
 * Description: https://leetcode.com/problems/find-the-distinct-difference-array/description/
 */

public class FindTheDistinctDifferenceArray {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], ans = new int[n];
        boolean[] marked = new boolean[51];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[nums[i]]) {
                marked[nums[i]] = true;
                count++;
            }
            left[i] = count;
        }
        marked = new boolean[51];
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = left[i] - count;
            if (!marked[nums[i]]) {
                marked[nums[i]] = true;
                count++;
            }
        }
        return ans;
    }
}

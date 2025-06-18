import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
 */

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < n / 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = nums[index];
                index++;
            }
            if (ans[i][2] - ans[i][0] > k) {
                return new int[0][];
            }
        }
        return ans;
    }
}

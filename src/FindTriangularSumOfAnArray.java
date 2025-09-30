/**
 * Description: https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
 */

public class FindTriangularSumOfAnArray {

    public int triangularSum(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}

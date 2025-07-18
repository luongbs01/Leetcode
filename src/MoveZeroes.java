/**
 * Description: https://leetcode.com/problems/move-zeroes/description/
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < n) {
            nums[index] = 0;
            index++;
        }
    }
}

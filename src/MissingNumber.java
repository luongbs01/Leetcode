/**
 * Description: https://leetcode.com/problems/missing-number/description/
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] exist = new boolean[nums.length + 1];
        for (int num : nums) {
            exist[num] = true;
        }
        for (int i = 0; i < exist.length; i++) {
            if (!exist[i]) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumberV2(int[] nums) {
        // refer to SingleNumber problem
        return -1;
    }
}

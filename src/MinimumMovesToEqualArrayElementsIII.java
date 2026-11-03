/**
 * Description: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/
 */

public class MinimumMovesToEqualArrayElementsIII {

    public int minMoves(int[] nums) {
        int n = nums.length, max = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        return n * max - sum;
    }
}

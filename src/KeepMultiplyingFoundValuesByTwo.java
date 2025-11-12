/**
 * Description: https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/
 */

public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        boolean[] arr = new boolean[1001];
        for (int i : nums) {
            arr[i] = true;
        }
        while (original <= 1000 && arr[original]) {
            original <<= 1;
        }
        return original;
    }
}

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
 */

public class MinimumOperationsToSortAPermutation {

    public int minOperations(int[] nums) {
        int n = nums.length, idx = 0;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }
        int dir = nums[(idx + 1 + n) % n] == 1 ? 1 : -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[(idx + i * dir + dir + n) % n] - nums[(idx + i * dir + n) % n] != 1) {
                return -1;
            }
        }
        if (dir == 1) {
            return Math.min(idx, n - idx + 2);
        } else {
            return 1 + Math.min(idx + 1, n - 1 - idx);
        }
    }
}

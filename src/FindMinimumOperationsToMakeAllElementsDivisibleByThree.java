/**
 * Description: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
 */

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            if (i % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}

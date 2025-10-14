import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/
 */

public class MaximumNumberOfDistinctElementsAfterOperations {

    public int maxDistinctElements(int[] nums, int k) {
        int ans = 0, min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i : nums) {
            int j = Math.max(Math.min(i + k, min + 1), i - k);
            if (j > min) {
                ans++;
                min = j;
            }
        }
        return ans;
    }
}

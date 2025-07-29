import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/description/
 */

public class SmallestSubarraysWithMaximumBitwiseOR {

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] pos = new int[32];
        Arrays.fill(pos, -1);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int max = i;
            for (int j = 0; j < 32; j++) {
                if (((1 << j) & nums[i]) != 0) {
                    pos[j] = i;
                } else {
                    max = Math.max(max, pos[j]);
                }
                ans[i] = max - i + 1;
            }
        }
        return ans;
    }
}

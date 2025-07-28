/**
 * Description: https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
 */

public class LargestCombinationWithBitwiseANDGreaterThanZero {

    public int largestCombination(int[] candidates) {
        int[] cnt = new int[32];
        for (int candidate : candidates) {
            int i = 0;
            while (candidate > 0) {
                if ((candidate & 1) != 0) {
                    cnt[i]++;
                }
                candidate >>= 1;
                i++;
            }
        }
        int ans = 0;
        for (int i : cnt) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}

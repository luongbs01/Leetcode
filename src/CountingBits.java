/**
 * Description: https://leetcode.com/problems/counting-bits/
 */

public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                ans[i] += j & 1;
                j >>= 1;
            }
        }
        return ans;
    }

    // dynamic programming
    public int[] countBitsV2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

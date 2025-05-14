/**
 * Description: https://leetcode.com/problems/reverse-bits/
 */

public class ReverseBits {

    public int reverseBits(int n) {
        int ans = n;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1) == 0) {
                ans &= ~(1 << i); // can be removed because default value is 0
            } else {
                ans |= (1 << i);
            }
            n >>= 1;
        }
        return ans;
    }

    public int reverseBitsV2(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1) == 1) {
                ans |= (1 << i);
            }
            n >>= 1;
        }
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/number-of-1-bits/description/
 */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}

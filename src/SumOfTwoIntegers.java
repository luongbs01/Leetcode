/**
 * Description: https://leetcode.com/problems/sum-of-two-integers/description/
 */

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int ans = 0;
        int m = 0, bit;
        for (int i = 0; i < 32; i++) {
            bit = ((a & 1) ^ (b & 1) ^ m);
            m = ((a & 1) & (b & 1)) == 1 || (((a & 1) | (b & 1)) == 1 && m == 1) ? 1 : 0;
            if (bit == 1) {
                ans = ans | 1 << i;
            } else {
                ans = ans & ~(1 << i); // can be removed because default value is 0
            }
            a >>= 1;
            b >>= 1;
        }
        return ans;
    }
}

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/description/
 */

public class MinimumOperationsToMakeTheIntegerZero {

    public int makeTheIntegerZero(int num1, int num2) {
        int k = 0;
        long n = num1;
        while (n > 0) {
            if (n >= k && countBit(n) <= k) {
                return k;
            }
            n -= num2;
            k++;
        }
        return -1;
    }

    private int countBit(long n) {
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}

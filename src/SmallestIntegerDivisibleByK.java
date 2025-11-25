/**
 * Description: https://leetcode.com/problems/smallest-integer-divisible-by-k/description/
 */

public class SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int ans = 1, remainder = 1 % k;
        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % k;
            ans++;
        }
        return ans;
    }
}

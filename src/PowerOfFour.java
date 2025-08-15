/**
 * Description: https://leetcode.com/problems/power-of-four/description/
 */

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n <= 0 || (n & 3) != 0) return false;
        return isPowerOfFour(n >> 2);
    }
}

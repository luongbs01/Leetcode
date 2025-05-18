/**
 * Description: https://leetcode.com/problems/sqrtx/description/
 */

public class Sqrt {
    public int mySqrt(int x) {
        int left = 0, right = (int) Math.floor(Math.sqrt(Integer.MAX_VALUE));
        int mid;
        while (left < right) {
            mid = (left + right + 1) >> 1;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

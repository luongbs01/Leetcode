/**
 * Description: https://leetcode.com/problems/palindrome-number/description/
 */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long y = 0, n = x;
        while (n != 0) {
            y = y * 10 + n % 10;
            n /= 10;
        }
        return x == y;
    }
}

/**
 * Description: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
 */

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 2; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                chars[j] = (char) ((chars[j] + chars[j + 1] - 2 * '0') % 10 + '0');
            }
        }
        return chars[0] == chars[1];
    }
}

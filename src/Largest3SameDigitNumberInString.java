/**
 * Description: https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
 */

public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        for (char c = '9'; c >= '0'; c--) {
            String str = String.valueOf(c).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }
}

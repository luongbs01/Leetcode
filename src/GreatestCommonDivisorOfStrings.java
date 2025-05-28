/**
 * Description: https://leetcode.com/problems/greatest-common-divisor-of-strings
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        while (length1 != length2) {
            if (length1 < length2) {
                length2 -= length1;
            } else {
                length1 -= length2;
            }
        }
        String str = str1.substring(0, length1);
        return str1.equals(str.repeat(str1.length() / length1)) && str2.equals(str.repeat(str2.length() / length2)) ? str : "";
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("AAAA", "AAAAAAAA"));
    }
}

/**
 * Description: https://leetcode.com/problems/valid-palindrome/description/
 */

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : c);
            }
        }
        String string = stringBuilder.toString();
        int length = string.length();
        int i = 0, j = length - 1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

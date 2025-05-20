/**
 * Description: https://leetcode.com/problems/reverse-integer/description/
 */

public class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        StringBuilder reversedString = new StringBuilder();
        for (int i = chars.length - 1; i >= (x > 0 ? 0 : 1); i--) {
            reversedString.append(chars[i]);
        }
        while (!reversedString.isEmpty() && reversedString.charAt(0) == '0') {
            reversedString.deleteCharAt(0);
        }
        String reversed = reversedString.toString();
        chars = reversed.toCharArray();
        int n = 0;
        for (char aChar : chars) {
            n = n * 10;
            n = isNegative ? n - (aChar - '0') : n + (aChar - '0');
        }
        if (isNegative) {
            reversed = "-" + reversed;
        }
        return String.valueOf(n).equals(reversed) ? Integer.parseInt(reversed) : 0;
    }

    public int reverseV2(int x) {
        int ans = 0;
        boolean isNegative = x < 0;
        while (x != 0) {
            int digit = x % 10;
            if ((isNegative && (Integer.MIN_VALUE - digit) / 10 <= ans)
                    || (!isNegative && (Integer.MAX_VALUE - digit) / 10 >= ans)) {
                ans = ans * 10 + digit;
            } else {
                return 0;
            }
            x /= 10;
        }
        return ans;
    }
}

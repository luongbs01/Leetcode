import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */

public class ReverseSubstringsBetweenEachPairOfParentheses {

    // O(n^2) 14ms
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb2 = new StringBuilder();
                while (sb.charAt(sb.length() - 1) != '(') {
                    sb2.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(sb2);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // O(n) 1ms
    public String reverseParenthesesV2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        ArrayDeque<Integer> openingIndex = new ArrayDeque<>();
        int[] link = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                openingIndex.push(i);
            } else if (chars[i] == ')') {
                link[i] = openingIndex.pop();
                link[link[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0, direction = 1; i < n; i += direction) {
            if (chars[i] >= 'a') {
                sb.append(chars[i]);
            } else {
                i = link[i];
                direction = -direction;
            }
        }
        return sb.toString();
    }
}

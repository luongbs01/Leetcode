/**
 * Description: https://leetcode.com/problems/shifting-letters/description/
 */

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long[] arr = new long[n];
        arr[n - 1] = shifts[n - 1];
        char[] chars = s.toCharArray();
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] + shifts[i];
            arr[i + 1] %= 26;
            chars[i + 1] = (char) ((chars[i + 1] + arr[i + 1]) > 'z' ? (chars[i + 1] + arr[i + 1] - 26)
                    : (chars[i + 1] + arr[i + 1]));
        }
        arr[0] %= 26;
        chars[0] = (char) ((chars[0] + arr[0]) > 'z' ? (chars[0] + arr[0] - 26) : (chars[0] + arr[0]));
        return new String(chars);
    }
}

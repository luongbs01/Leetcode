/**
 * Description: https://leetcode.com/problems/number-of-substrings-with-only-1s/description/
 */

public class NumberOfSubstringsWithOnly1s {

    public int numSub(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0;
        long ans = 0;
        while (l < n) {
            long count = 0;
            while (l < n && chars[l] == '1') {
                l++;
                count++;
            }
            ans += count * (count + 1) / 2;
            while (l < n && chars[l] == '0') {
                l++;
            }
        }
        return (int) (ans % 1000000007);
    }

    public int numSubV2(String s) {
        char[] chars = s.toCharArray();
        long ans = 0, count = 0;
        for (char c : chars) {
            if (c == '1') {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 0;
            }
        }
        ans += count * (count + 1) / 2;
        return (int) (ans % 1000000007);
    }
}

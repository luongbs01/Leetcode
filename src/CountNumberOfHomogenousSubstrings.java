/**
 * Description: https://leetcode.com/problems/count-number-of-homogenous-substrings/description/
 */

public class CountNumberOfHomogenousSubstrings {

    public int countHomogenous(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        long ans = 0;
        long count = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                ans += (count * (count + 1) / 2);
                count = 1;
            } else {
                count++;
            }
        }
        ans += (count * (count + 1) / 2);
        return (int) (ans % 1000000007);
    }
}

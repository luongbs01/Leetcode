/**
 * Description: https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/
 */

public class CalculateDigitSumOfAString {

    public String digitSum(String s, int k) {
        StringBuilder ans = new StringBuilder(s);
        while (ans.length() > k) {
            StringBuilder curr = new StringBuilder();
            int n = ans.length(), sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (ans.charAt(i) - '0');
                if ((i + 1) % k == 0 || i == n - 1) {
                    curr.append(sum);
                    sum = 0;
                }
            }
            ans = new StringBuilder(curr);
        }
        return ans.toString();
    }
}

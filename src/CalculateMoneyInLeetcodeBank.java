/**
 * Description: https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 */

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int ans = 0, prev = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                prev++;
                count = prev;
            }
            ans += count;
            count++;
        }
        return ans;
    }
}

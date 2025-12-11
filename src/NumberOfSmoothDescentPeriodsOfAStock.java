/**
 * Description: https://leetcode.com/problems/count-covered-buildings/
 */

public class NumberOfSmoothDescentPeriodsOfAStock {

    public long getDescentPeriods(int[] prices) {
        long ans = 0, count = 1;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] != prices[i - 1] - 1) {
                ans += (count * (count + 1)) >> 1;
                count = 1;
            } else {
                count++;
            }
        }
        ans += (count * (count + 1)) >> 1;
        return ans;
    }
}

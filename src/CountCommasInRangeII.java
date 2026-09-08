/**
 * Description: https://leetcode.com/problems/count-commas-in-range-ii/
 */

public class CountCommasInRangeII {

    public long countCommas(long n) {
        long ans = 0;
        for (int i = 1; i <= 5; i++) {
            long l = Math.powExact(10L, i * 3);
            long r = Math.min(n, Math.powExact(10L, (i + 1) * 3) - 1);
            if (r >= l) {
                ans += (r - l + 1) * i;
            }
        }
        return ans;
    }
}

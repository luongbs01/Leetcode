/**
 * Description: https://leetcode.com/problems/maximum-running-time-of-n-computers/
 */

public class MaximumRunningTimeOfNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long l = 1, r = 0;
        for (int battery : batteries) {
            r += battery;
        }
        r /= n;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            long sum = 0;
            for (int battery : batteries) {
                sum += Math.min(battery, mid);
            }
            if (sum >= n * mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

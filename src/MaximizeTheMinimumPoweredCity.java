/**
 * Description: https://leetcode.com/problems/maximize-the-minimum-powered-city/
 */

public class MaximizeTheMinimumPoweredCity {

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = Long.MAX_VALUE, right;
        long[] prefix = new long[n], power = new long[n];
        prefix[0] = stations[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stations[i];
        }
        for (int i = 0; i < n; i++) {
            power[i] = prefix[Math.min(i + r, n - 1)] - (i - r - 1 >= 0 ? prefix[i - r - 1] : 0);
            left = Math.min(left, power[i]);
        }
        right = left + k;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (isValid(power, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid(long[] power, long r, long k, long mid) {
        long[] diff = new long[power.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = power[i + 1] - power[i];
        }
        long sum = power[0];
        for (int i = 0; i < power.length; i++) {
            if (sum < mid) { // sum: number of power stations in the ith city
                long add = mid - sum;
                k -= add;
                if (k < 0) return false;
                if (diff.length > 0) diff[Math.min(diff.length - 1, i)] += add;
                if (i + 2 * r <= diff.length - 1) diff[(int) (i + 2 * r)] -= add;
            }
            if (i < power.length - 1) sum += diff[i];
        }
        return true;
    }
}

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */

public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, l = Arrays.stream(bloomDay).min().getAsInt(), r = Arrays.stream(bloomDay).max().getAsInt(), mid;
        if ((long) m * k > n)
            return -1;
        if ((long) m * k == n)
            return r;
        while (l < r) {
            mid = (l + r) >> 1;
            if (canMakeBouquet(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canMakeBouquet(int[] bloomDay, int day, int m, int k) {
        int count = 0, cnt = 0;
        for (int i : bloomDay) {
            if (i <= day) {
                cnt++;
                if (cnt == k) {
                    count++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return count >= m;
    }
}

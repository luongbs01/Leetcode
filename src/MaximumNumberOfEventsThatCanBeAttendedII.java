import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/
 */

public class MaximumNumberOfEventsThatCanBeAttendedII {

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        int[][] dp = new int[k + 2][n + 2];
        int ans = 0;
        for (int i = k; i >= 1; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i][j + 1],
                        dp[i + 1][binarySearch(events, events[j][1] + 1)] + events[j][2]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private int binarySearch(int[][] events, int startDate) {
        int l = 0, r = events.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][0] < startDate) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */

public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        // [start, end, profit]
        int[][] jobs = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            jobs[i + 1] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));

        // dp[i]: maximum profit when choosing first i jobs
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (jobs[mid][1] <= jobs[i][0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            // knapsack: pick or not pick?
            dp[i] = Math.max(dp[i - 1], jobs[i][2] + dp[l]);
        }
        return dp[n];
    }
}

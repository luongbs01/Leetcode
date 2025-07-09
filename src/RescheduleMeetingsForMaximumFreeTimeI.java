/**
 * Description: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/
 */

public class RescheduleMeetingsForMaximumFreeTimeI {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length + 1;
        int[] gap = new int[n];
        gap[0] = startTime[0];
        gap[n - 1] = eventTime - endTime[endTime.length - 1];
        for (int i = 1; i < n - 1; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += gap[i];
        }
        int ans = sum;
        for (int i = k + 1; i < n; i++) {
            sum = sum + gap[i] - gap[i - k - 1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

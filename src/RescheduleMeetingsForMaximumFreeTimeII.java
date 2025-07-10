import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/description/
 */

public class RescheduleMeetingsForMaximumFreeTimeII {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        gap[n] = eventTime - endTime[n - 1];
        for (int i = 1; i < n; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        int[] maxValueExcludingTwoAdj = maxValueExcludingTwoAdj(gap, n + 1);
        System.out.println(Arrays.toString(maxValueExcludingTwoAdj));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int duration = endTime[i] - startTime[i];
            if (maxValueExcludingTwoAdj[i] >= duration) {
                ans = Math.max(ans, gap[i] + duration + gap[i + 1]);
            } else {
                ans = Math.max(ans, gap[i] + gap[i + 1]);
            }
        }
        return ans;
    }

    // Heap, many cases, complicated
    private int[] maxValueExcludingTwoAdj(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for (int i : arr) {
            if (pq.size() < 3) {
                pq.offer(i);
            } else if (pq.peek() <= i) {
                pq.offer(i);
                pq.poll();
            }
        }
        int[] top3 = new int[3];
        for (int i = 0; i < 3; i++) {
            top3[i] = pq.poll();
        }
        int[] ans = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(arr[i], arr[i + 1]);
            int min = Math.min(arr[i], arr[i + 1]);
            if (top3[0] == top3[2]) {
                ans[i] = top3[0];
            } else if (max < top3[2]) {
                ans[i] = top3[2];
            } else if (max == top3[2]) {
                if (min == top3[1]) {
                    ans[i] = top3[0];
                } else {
                    ans[i] = top3[1];
                }
            }
        }
        return ans;
    }

    // Prefix sum, easier to implement
    private int[] maxValueExcludingTwoAdjV2(int[] arr, int n) {
        int[] maxLeft = new int[n], maxRight = new int[n];
        maxLeft[0] = arr[0];
        maxRight[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], arr[i]);
        }
        System.out.println("maxLeft: " + Arrays.toString(maxLeft));
        System.out.println("maxRight: " + Arrays.toString(maxRight));
        int[] ans = new int[n - 1];
        ans[0] = maxRight[2];
        arr[n - 2] = maxLeft[n - 3];
        for (int i = 1; i < n - 2; i++) {
            arr[i] = Math.max(maxLeft[i - 1], maxRight[i + 2]);
        }
        return ans;
    }
}

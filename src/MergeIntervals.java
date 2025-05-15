import java.util.*;

/**
 * Description: https://leetcode.com/problems/merge-intervals/description/
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            pq.offer(interval);
        }
        Stack<int[]> stack = new Stack<>();
        stack.push(pq.poll());
        while (!pq.isEmpty()) {
            int[] interval = pq.poll();
            if (isOverlap(stack.peek(), interval)) {
                int[] newInterval = mergeOverlap(stack.pop(), interval);
                stack.push(newInterval);
            } else {
                stack.push(interval);
            }
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public int[][] mergeV2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] <= ans.getLast()[1]) {
                ans.getLast()[1] = Math.max(currInterval[1], ans.getLast()[1]);
            } else {
                ans.add(currInterval);
            }
        }
        return ans.toArray(new int[0][0]);
    }

    private boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0];
    }

    private int[] mergeOverlap(int[] interval1, int[] interval2) {
        return new int[]{interval1[0], Math.max(interval1[1], interval2[1])};
    }
}

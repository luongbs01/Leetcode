import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/non-overlapping-intervals/description/
 */

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int maxPossibleIntervals = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= end && interval[1] > end) {
                maxPossibleIntervals++;
                end = interval[1];
            }
        }
        return intervals.length - maxPossibleIntervals;
    }
}

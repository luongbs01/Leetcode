import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/insert-interval/description/
 */

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> mergedInterval = new LinkedList<>();
        for (int[] interval : intervals) {
            mergedInterval.add(interval);
        }
        mergedInterval.add(newInterval);
        int[][] merged = mergedInterval.toArray(new int[0][]);
        Arrays.sort(merged, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(merged[0]);
        for (int i = 1; i < merged.length; i++) {
            int[] currInterval = merged[i];
            if (currInterval[0] <= ans.getLast()[1]) {
                ans.getLast()[1] = Math.max(ans.getLast()[1], currInterval[1]);
            } else {
                ans.add(currInterval);
            }
        }
        return ans.toArray(new int[0][]);
    }
}

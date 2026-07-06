import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/remove-covered-intervals/
 */

public class RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		int n = intervals.length, cnt = 0, idx = 0;
		Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));
		for (int i = 1; i < n; i++) {
			while (!(intervals[idx][0] <= intervals[i][0] && intervals[idx][1] >= intervals[i][1])) {
				idx++;
			}
			if (idx < i) {
				cnt++;
			}
		}
		return n - cnt;
	}
}

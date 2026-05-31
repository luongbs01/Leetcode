import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/range-frequency-queries/description/
 */

public class RangeFrequencyQueries {

	class RangeFreqQuery {

		HashMap<Integer, List<Integer>> freq = new HashMap<>();

		public RangeFreqQuery(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				freq.computeIfAbsent(arr[i], (k) -> new ArrayList<>()).add(i);
			}
		}

		public int query(int left, int right, int value) {
			List<Integer> indices = freq.get(value);
			if (indices == null || indices.getFirst() > right || indices.getLast() < left) {
				return 0;
			}
			int l = 0, r = indices.size() - 1;
			while (l < r) {
				int mid = (l + r) >> 1;
				if (indices.get(mid) < left) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			int firstIndex = l;

			l = 0;
			r = indices.size() - 1;
			while (l < r) {
				int mid = (l + r + 1) >> 1;
				if (indices.get(mid) > right) {
					r = mid - 1;
				} else {
					l = mid;
				}
			}

			return l - firstIndex + 1;
		}
	}
}

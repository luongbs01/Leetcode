import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/
 */

public class MinimumPairRemovalToSortArrayI {

	public int minimumPairRemoval(int[] nums) {
		int ans = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i : nums) {
			list.add(i);
		}
		while (list.size() > 1) {
			Iterator<Integer> iterator = list.iterator();
			int curr;
			int next = iterator.next();
			int minSum = Integer.MAX_VALUE, idx = -1, i = -1;
			boolean isNonDecreasing = true;
			while (iterator.hasNext()) {
				i++;
				curr = next;
				next = iterator.next();
				if (minSum > curr + next) {
					minSum = curr + next;
					idx = i;
				}
				if (curr > next) {
					isNonDecreasing = false;
				}
			}
			if (isNonDecreasing) {
				break;
			} else {
				ans++;
				list.set(idx, minSum);
				list.remove(idx + 1);
			}
		}
		return ans;
	}
}

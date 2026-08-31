import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

	public int[] nodesBetweenCriticalPoints(ListNode head) {
		List<Integer> arr = new ArrayList<>();
		int idx = 0;
		ListNode prev = head, curr = head.next;
		while (curr != null && curr.next != null) {
			if ((prev.val > curr.val && curr.next.val > curr.val)
				|| (prev.val < curr.val && curr.next.val < curr.val)) {
				arr.add(idx);
			}
			idx++;
			prev = curr;
			curr = curr.next;
		}
		if (arr.size() < 2) {
			return new int[] { -1, -1 };
		}
		int maxDistance = arr.getLast() - arr.getFirst();
		int minDistance = maxDistance;
		for (int i = 1; i < arr.size(); i++) {
			minDistance = Math.min(minDistance, arr.get(i) - arr.get(i - 1));
		}
		return new int[] { minDistance, maxDistance };
	}
}

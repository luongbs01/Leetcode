import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
 */

public class SortIntegersByTheNumberOf1Bits {

	public int[] sortByBits(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int cnt1 = Integer.bitCount(o1);
			int cnt2 = Integer.bitCount(o2);
			return cnt1 == cnt2 ? o1 - o2 : cnt1 - cnt2;
		});
		for (int i : arr) {
			pq.offer(i);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = pq.poll();
		}
		return arr;
	}
}

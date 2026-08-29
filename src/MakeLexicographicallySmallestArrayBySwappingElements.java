import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */

public class MakeLexicographicallySmallestArrayBySwappingElements {

	public int[] lexicographicallySmallestArray(int[] nums, int limit) {
		int n = nums.length, l = 0;
		int[][] sortedArr = new int[n][2];
		for (int i = 0; i < n; i++) {
			sortedArr[i][0] = nums[i];
			sortedArr[i][1] = i;
		}
		Arrays.sort(sortedArr, Comparator.comparingInt(o -> o[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(sortedArr[0][1]);
		for (int r = 1; r < n; r++) {
			if (sortedArr[r][0] - sortedArr[r - 1][0] > limit) {
				while (!pq.isEmpty()) {
					nums[pq.poll()] = sortedArr[l][0];
					l++;
				}
			}
			pq.offer(sortedArr[r][1]);
		}

		while (!pq.isEmpty()) {
			nums[pq.poll()] = sortedArr[l][0];
			l++;
		}
		return nums;
	}
}

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
 */

public class LengthOfLongestSubarrayWithAtMostKFrequency {

	public int maxSubarrayLength(int[] nums, int k) {
		Map<Integer, Queue<Integer>> map = new HashMap<>();
		int n = nums.length, ans = 0, idx = -1;
		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = map.get(nums[i]);
			if (queue != null && queue.size() == k) {
				idx = Math.max(idx, queue.poll());
			}
			map.putIfAbsent(nums[i], new ArrayDeque<>());
			map.get(nums[i]).offer(i);
			ans = Math.max(ans, i - idx);
		}
		return ans;
	}
}

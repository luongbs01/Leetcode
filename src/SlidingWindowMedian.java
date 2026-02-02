import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/sliding-window-median/description/
 */

public class SlidingWindowMedian {

	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		TreeSet<Integer> left = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : Integer.compare(nums[o1], nums[o2]));
		TreeSet<Integer> right = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : Integer.compare(nums[o1], nums[o2]));
		double[] ans = new double[n - k + 1];
		for (int i = 0; i < k; i++) {
			left.add(i);
		}
		for (int i = k - 1; i < n; i++) {
			if (k == 1) {
				ans[i] = nums[i];
				continue;
			}

			while (left.size() - right.size() > 1) {
				right.add(left.pollLast());
			}
			while (right.size() - left.size() > 1) {
				left.add(right.pollFirst());
			}
			while (!left.isEmpty() && !right.isEmpty() && nums[left.last()] > nums[right.first()]) {
				int min = left.pollLast();
				int max = right.pollFirst();
				left.add(max);
				right.add(min);
			}

			if (left.size() == right.size()) {
				ans[i - k + 1] = ((double) nums[left.last()] + (double) nums[right.first()]) / 2.0;
			} else if (left.size() > right.size()) {
				ans[i - k + 1] = nums[left.last()];
			} else {
				ans[i - k + 1] = nums[right.first()];
			}

			if (!left.remove(i - k + 1)) {
				right.remove(i - k + 1);
			}
			if (i + 1 < n)
				left.add(i + 1);
		}
		return ans;
	}
}

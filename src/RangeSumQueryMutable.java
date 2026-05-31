/**
 * Description: https://leetcode.com/problems/range-sum-query-mutable/
 */

public class RangeSumQueryMutable {

	class NumArray {

		int[] seg;
		int n;

		public NumArray(int[] nums) {
			n = nums.length;
			seg = new int[n << 2];
			build(1, 0, n - 1, nums);
		}

		public void update(int index, int val) {
			update(1, 0, n - 1, index, val);
		}

		public int sumRange(int left, int right) {
			return query(1, 0, n - 1, left, right);
		}

		private void build(int p, int l, int r, int[] nums) {
			if (l == r) {
				seg[p] = nums[l];
				return;
			}
			int mid = (l + r) >> 1;
			build(p << 1, l, mid, nums);
			build((p << 1) | 1, mid + 1, r, nums);
			seg[p] = seg[p << 1] + seg[(p << 1) | 1];
		}

		private void update(int p, int l, int r, int index, int val) {
			if (l == r) {
				seg[p] = val;
				return;
			}
			if (index < l || index > r) {
				return;
			}
			int mid = (l + r) >> 1;
			if (index <= mid) {
				update(p << 1, l, mid, index, val);
			} else {
				update((p << 1) | 1, mid + 1, r, index, val);
			}
			seg[p] = seg[p << 1] + seg[(p << 1) | 1];
		}

		private int query(int p, int l, int r, int left, int right) {
			if (l >= left && r <= right) {
				return seg[p];
			}
			int mid = (l + r) >> 1;
			int sum = 0;
			if (mid >= left) {
				sum += query(p << 1, l, mid, left, right);
			}
			if (mid + 1 <= right) {
				sum += query(((p << 1) | 1), mid + 1, r, left, right);
			}
			return sum;
		}
	}
}

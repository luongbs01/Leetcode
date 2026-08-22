import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/distribute-elements-into-two-arrays-ii/description/
 */

public class DistributeElementsIntoTwoArraysII {

	// both approaches are similar to this solution https://leetcode.com/problems/distribute-elements-into-two-arrays-ii/solutions/4934907/editorial-covering-all-approaches-by-sin-iwn8
	// segment tree
	public int[] resultArrayV1(int[] nums) {
		int n = nums.length;
		int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		arr1.add(nums[0]);
		arr2.add(nums[1]);
		SegmentTree segTree1 = new SegmentTree(arr);
		SegmentTree segTree2 = new SegmentTree(arr);
		segTree1.update(nums[0]);
		segTree2.update(nums[1]);
		for (int i = 2; i < n; i++) {
			int cnt1 = segTree1.greaterCount(nums[i]);
			int cnt2 = segTree2.greaterCount(nums[i]);
			if ((cnt1 > cnt2) || (cnt1 == cnt2 && arr1.size() <= arr2.size())) {
				arr1.add(nums[i]);
				segTree1.update(nums[i]);
			} else {
				arr2.add(nums[i]);
				segTree2.update(nums[i]);
			}
		}
		arr1.addAll(arr2);
		return arr1.stream().mapToInt(a -> a).toArray();
	}

	static class SegmentTree {
		int n;
		// seg[i]: number of elements in range [arr[l], arr[r]]
		int[] seg;
		int[] arr;

		public SegmentTree(int[] arr) {
			this.arr = arr;
			this.n = arr.length;
			seg = new int[n << 2];
		}

		public void update(int val) {
			update(1, 0, n - 1, val);
		}

		public int greaterCount(int val) {
			return query(1, 0, n - 1, val);
		}

		private void update(int idx, int l, int r, int val) {
			if (l == r && arr[l] == val) {
				seg[idx]++;
				return;
			}
			if (arr[l] > val || arr[r] < val) {
				return;
			}
			int mid = (l + r) >> 1;
			update(idx << 1, l, mid, val);
			update((idx << 1) | 1, mid + 1, r, val);
			seg[idx] = seg[idx << 1] + seg[(idx << 1) | 1];
		}

		private int query(int idx, int l, int r, int val) {
			if (arr[l] > val) {
				return seg[idx];
			}
			if (arr[r] <= val) {
				return 0;
			}
			if (l == r && arr[l] == val) {
				return 0;
			}
			int mid = (l + r) >> 1;
			return query(idx << 1, l, mid, val) + query((idx << 1) | 1, mid + 1, r, val);
		}
	}

	// binary indexed tree
	public int[] resultArray(int[] nums) {
		int n = nums.length;
		int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		arr1.add(nums[0]);
		arr2.add(nums[1]);
		BIT bit1 = new BIT(n, arr);
		BIT bit2 = new BIT(n, arr);
		bit1.add(nums[0]);
		bit2.add(nums[1]);
		for (int i = 2; i < n; i++) {
			int cnt1 = bit1.greaterCount(nums[i]);
			int cnt2 = bit2.greaterCount(nums[i]);
			if ((cnt1 > cnt2) || (cnt1 == cnt2 && arr1.size() <= arr2.size())) {
				arr1.add(nums[i]);
				bit1.add(nums[i]);
			} else {
				arr2.add(nums[i]);
				bit2.add(nums[i]);
			}
		}
		arr1.addAll(arr2);
		return arr1.stream().mapToInt(a -> a).toArray();
	}

	static class BIT {
		int n, size;
		int[] BIT; // numbers elements smaller than or equals arr[i]
		int[] arr;
		Map<Integer, Integer> map;

		public BIT(int n, int[] arr) {
			this.n = n;
			this.size = 0;
			this.arr = arr;
			map = new HashMap<>(n);
			for (int i = 0; i < arr.length; i++) {
				map.put(arr[i], i);
			}
			BIT = new int[n + 1];
		}

		public void add(int val) {
			size++;
			int idx = map.get(val);
			update(idx + 1, 1);
		}

		public int greaterCount(int val) {
			int idx = map.get(val);
			return size - query(idx + 1);
		}

		private void update(int idx, int amount) {
			while (idx <= n) {
				BIT[idx] += amount;
				idx += (idx & (-idx));
			}
		}

		// get numbers of element less than or equal arr[idx-1]
		private int query(int idx) {
			int total = 0;
			while (idx > 0) {
				total += BIT[idx];
				idx -= (idx & (-idx));
			}
			return total;
		}
	}
}

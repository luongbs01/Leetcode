import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-total-subarray-value-ii/
 */

public class MaximumTotalSubarrayValueII {

	int[] nums;
	int n;

	private class MinSegmentTree {
		int[] seg;

		public MinSegmentTree() {
			seg = new int[n << 2];
			buildTree(1, 0, n - 1);
		}

		private void buildTree(int p, int l, int r) {
			if (l == r) {
				seg[p] = nums[l];
				return;
			}

			int mid = (l + r) >> 1;
			buildTree(p << 1, l, mid);
			buildTree((p << 1) | 1, mid + 1, r);
			seg[p] = Math.min(seg[p << 1], seg[(p << 1) | 1]);
		}

		private int query(int p, int l, int r, int lQuery, int rQuery) {
			if (l >= lQuery && r <= rQuery) {
				return seg[p];
			}
			if (r < lQuery || l > rQuery) {
				return Integer.MAX_VALUE;
			}

			int mid = (l + r) >> 1;
			int min1 = query(p << 1, l, mid, lQuery, rQuery);
			int min2 = query((p << 1) | 1, mid + 1, r, lQuery, rQuery);
			return Math.min(min1, min2);
		}
	}

	private class MaxSegmentTree {
		int[] seg;

		public MaxSegmentTree() {
			seg = new int[n << 2];
			buildTree(1, 0, n - 1);
		}

		private void buildTree(int p, int l, int r) {
			if (l == r) {
				seg[p] = nums[l];
				return;
			}

			int mid = (l + r) >> 1;
			buildTree(p << 1, l, mid);
			buildTree((p << 1) | 1, mid + 1, r);
			seg[p] = Math.max(seg[p << 1], seg[(p << 1) | 1]);
		}

		private int query(int p, int l, int r, int lQuery, int rQuery) {
			if (l >= lQuery && r <= rQuery) {
				return seg[p];
			}
			if (r < lQuery || l > rQuery) {
				return Integer.MIN_VALUE;
			}

			int mid = (l + r) >> 1;
			int max1 = query(p << 1, l, mid, lQuery, rQuery);
			int max2 = query((p << 1) | 1, mid + 1, r, lQuery, rQuery);
			return Math.max(max1, max2);
		}
	}

	public long maxTotalValue(int[] nums, int k) {
		this.nums = nums;
		this.n = nums.length;
		long ans = 0;
		HashMap<Integer, Set<Integer>> visited = new HashMap<>();
		MinSegmentTree minSegmentTree = new MinSegmentTree();
		MaxSegmentTree maxSegmentTree = new MaxSegmentTree();
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
		maxHeap.offer(new int[] {
			maxSegmentTree.query(1, 0, n - 1, 0, n - 1) - minSegmentTree.query(1, 0, n - 1, 0, n - 1),
			k, 0, n - 1 });
		while (k > 0) {
			int[] e = maxHeap.poll();
			int lQuery = e[2], rQuery = e[3];
			if (!visited.getOrDefault(lQuery, new HashSet<>()).contains(rQuery)) {
				visited.computeIfAbsent(lQuery, key -> new HashSet<>()).add(rQuery);
				ans += e[0];
				if (lQuery < rQuery) {
					maxHeap.offer(new int[] {
						maxSegmentTree.query(1, 0, n - 1, lQuery + 1, rQuery)
							- minSegmentTree.query(1, 0, n - 1, lQuery + 1, rQuery),
						k, lQuery + 1, rQuery });
					maxHeap.offer(new int[] {
						maxSegmentTree.query(1, 0, n - 1, lQuery, rQuery - 1)
							- minSegmentTree.query(1, 0, n - 1, lQuery, rQuery - 1),
						k, lQuery, rQuery - 1 });
				}
				k--;
			}
		}
		return ans;
	}
}

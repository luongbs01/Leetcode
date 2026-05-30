import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/block-placement-queries/description/
 */

public class BlockPlacementQueries {

	int mx = 50_001;
	int[] seg = new int[mx << 2];

	void update(int p, int l, int r, int idx, int val) {
		if (l == r) {
			seg[p] = val;
			return;
		}

		int mid = (l + r) >> 1;
		if (idx <= mid) {
			update(p << 1, l, mid, idx, val);
		} else {
			update((p << 1) | 1, mid + 1, r, idx, val);
		}
		seg[p] = Math.max(seg[p << 1], seg[(p << 1) | 1]);
	}

	int query(int p, int l, int r, int L, int R) {
		if (L <= l && R >= r) {
			return seg[p];
		}

		int mid = (l + r) >> 1;
		int max = 0;
		if (L <= mid) {
			max = Math.max(max, query(p << 1, l, mid, L, R));
		}
		if (R > mid) {
			max = Math.max(max, query((p << 1) | 1, mid + 1, r, L, R));
		}
		return max;
	}

	public List<Boolean> getResults(int[][] queries) {
		List<Boolean> ans = new ArrayList<>();
		TreeSet<Integer> obstables = new TreeSet<>();
		obstables.add(0);
		obstables.add(mx);
		update(1, 0, mx, mx, mx);
		for (int[] query : queries) {
			int x = query[1];
			if (query[0] == 1) {
				obstables.add(x);
				int left = obstables.lower(x);
				int right = obstables.higher(x);
				update(1, 0, mx, x, x - left);
				update(1, 0, mx, right, right - x);
			} else {
				int sz = query[2];
				int left = obstables.lower(x);
				int max = query(1, 0, mx, 0, left);
				max = Math.max(max, x - left);
				ans.add(max >= sz);
			}
		}
		return ans;
	}
}

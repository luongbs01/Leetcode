import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/description/
 */

public class MaximizeSpanningTreeStabilityWithUpgrades {

	int[] rank, size, originalRank, originalSize;

	public int maxStability(int n, int[][] edges, int k) {
		rank = new int[n];
		size = new int[n];
		originalRank = new int[n];
		originalSize = new int[n];
		for (int i = 0; i < n; i++) {
			rank[i] = i;
			size[i] = 1;
		}
		int min = 200_000;
		List<int[]> list = new ArrayList<>();
		for (int[] edge : edges) {
			if (edge[3] == 1) {
				min = Math.min(min, edge[2]);
				if (!union(edge[0], edge[1])) {
					return -1;
				}
			} else {
				list.add(new int[] { edge[0], edge[1], edge[2] });
			}
		}
		list.sort(Comparator.comparingInt(o -> -o[2]));
		int l = 0, r = min;
		System.arraycopy(rank, 0, originalRank, 0, n);
		System.arraycopy(size, 0, originalSize, 0, n);

		while (l < r) {
			int mid = (l + r + 1) >> 1;
			if (valid(n, list, mid, k)) {
				l = mid;
			} else {
				r = mid - 1;
			}
			System.arraycopy(originalRank, 0, rank, 0, n);
			System.arraycopy(originalSize, 0, size, 0, n);
		}
		return l > 0 ? l : -1;
	}

	private boolean valid(int n, List<int[]> list, int mid, int k) {
		for (int[] edge : list) {
			if (edge[2] >= mid) {
				union(edge[0], edge[1]);
			} else if (k > 0 && edge[2] * 2 >= mid && union(edge[0], edge[1])) {
				k--;
			}
		}
		return size[0] == n;
	}

	private int find(int u) {
		if (rank[u] == u) {
			return u;
		}
		int pU = find(rank[u]);
		rank[u] = pU;
		return pU;
	}

	private boolean union(int u, int v) {
		int pU = find(u);
		int pV = find(v);
		if (pU == pV) {
			return false;
		}
		if (pU > pV) {
			int temp = pU;
			pU = pV;
			pV = temp;
		}
		rank[pV] = pU;
		size[pU] += size[pV];
		return true;
	}
}

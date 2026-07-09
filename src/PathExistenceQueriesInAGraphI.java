/**
 * Description: https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/
 */

public class PathExistenceQueriesInAGraphI {

	int[] parent;

	public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
		this.parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 1; i < n; i++) {
			if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
				union(i - 1, i);
			}
		}
		int m = queries.length;
		boolean[] ans = new boolean[m];
		for (int i = 0; i < m; i++) {
			ans[i] = find(queries[i][0]) == find(queries[i][1]);
		}
		return ans;
	}

	public boolean[] pathExistenceQueriesV2(int n, int[] nums, int maxDiff, int[][] queries) {
		int[] parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 1; i < n; i++) {
			if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
				parent[i] = parent[i - 1];
			}
		}
		int m = queries.length;
		boolean[] ans = new boolean[m];
		for (int i = 0; i < m; i++) {
			ans[i] = parent[queries[i][0]] == parent[queries[i][1]];
		}
		return ans;
	}

	private int find(int u) {
		if (u == parent[u]) {
			return u;
		}
		int pU = find(parent[u]);
		parent[u] = pU;
		return pU;
	}

	private void union(int u, int v) {
		int pU = find(u);
		int pV = find(v);
		if (pU == pV) {
			return;
		}
		if (pU > pV) {
			int temp = pU;
			pU = pV;
			pV = temp;
		}
		parent[pV] = pU;
	}
}

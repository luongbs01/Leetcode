import java.util.ArrayList;

/**
 * Description: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/
 */

public class NumberOfWaysToAssignEdgeWeightsII {

	static int[] ways = new int[1_000_000];

	static {
		ways[0] = 1;
		for (int i = 1; i < ways.length; i++) {
			ways[i] = (ways[i - 1] << 1) % 1_000_000_007;
		}
	}

	int n;
	int[] h;
	int[][] up; // up[i][j]: 2^j th ancestor of node i => up[i][0]: parent of node i
	ArrayList<Integer>[] adj;

	public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
		n = edges.length + 1;
		h = new int[n + 1];
		up = new int[n + 1][17];
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}

		dfs(1);

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int u = queries[i][0], v = queries[i][1];
			int lca = lca(u, v);
			int len = h[u] + h[v] - (h[lca] << 1);
			ans[i] = len > 0 ? ways[len - 1] : 0;
		}
		return ans;
	}

	private int lca(int u, int v) {
		if (u == v) {
			return u;
		}
		if (h[u] < h[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		int diff = h[u] - h[v];
		for (int k = 16; k >= 0; k--) {
			if (((1 << k) & diff) != 0) {
				u = up[u][k];
			}
		}
		if (u == v) {
			return u;
		}
		for (int k = 16; k >= 0; k--) {
			if (up[u][k] != up[v][k]) {
				u = up[u][k];
				v = up[v][k];
			}
		}
		return up[u][0];
	}

	private void dfs(int curr) {
		for (int child : adj[curr]) {
			if (child == up[curr][0]) {
				continue;
			}
			h[child] = h[curr] + 1;
			up[child][0] = curr;
			for (int k = 1; (1 << k) < h[child]; k++) {
				up[child][k] = up[up[child][k - 1]][k - 1]; // 2^(k-1) + 2^(k-1) = 2^k
			}
			dfs(child);
		}
	}
}

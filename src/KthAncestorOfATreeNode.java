import java.util.ArrayList;

/**
 * Description: https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 */

public class KthAncestorOfATreeNode {

	class TreeAncestor {

		ArrayList<Integer>[] children;
		int[] h;
		int[][] up;

		public TreeAncestor(int n, int[] parent) {
			children = new ArrayList[n];
			h = new int[n];
			up = new int[n][16];
			for (int i = 0; i < n; i++) {
				children[i] = new ArrayList<>();
			}
			for (int i = 1; i < n; i++) {
				children[parent[i]].add(i);
			}

			dfs(0);
		}

		public int getKthAncestor(int node, int k) {
			if (k > h[node]) {
				return -1;
			}
			int leadingZero = Integer.numberOfLeadingZeros(k);
			for (int i = 32 - leadingZero; i >= 0; i--) {
				if (((k >> i) & 1) != 0) {
					node = up[node][i];
				}
			}
			return node;
		}

		private void dfs(int curr) {
			for (int child : children[curr]) {
				h[child] = h[curr] + 1;
				up[child][0] = curr;
				for (int i = 1; (1 << i) < h[child]; i++) {
					up[child][i] = up[up[child][i - 1]][i - 1];
				}
				dfs(child);
			}
		}
	}

}

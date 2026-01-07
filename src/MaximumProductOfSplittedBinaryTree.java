/**
 * Description: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */

public class MaximumProductOfSplittedBinaryTree {

	public int maxProduct(TreeNode root) {
		dfs(root);
		long sum = root.val;
		long ans = max(root, sum);
		return (int) (ans % 1_000_000_007);
	}

	private void dfs(TreeNode node) {
		if (node.left != null) dfs(node.left);
		if (node.right != null) dfs(node.right);
		if (node.left != null) node.val += node.left.val;
		if (node.right != null) node.val += node.right.val;
	}

	private long max(TreeNode node, long sum) {
		if (node == null) return 0;
		return Math.max(node.val * (sum - node.val), Math.max(max(node.left, sum), max(node.right, sum)));
	}
}

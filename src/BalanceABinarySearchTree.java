import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */

public class BalanceABinarySearchTree {

	List<Integer> values = new ArrayList<>();

	public TreeNode balanceBST(TreeNode root) {
		inOrder(root);
		return buildBST(0, values.size() - 1);
	}

	private void inOrder(TreeNode node) {
		if (node.left != null) inOrder(node.left);
		values.add(node.val);
		if (node.right != null) inOrder(node.right);
	}

	private TreeNode buildBST(int left, int right) {
		if (left > right) return null;
		if (left == right) return new TreeNode(values.get(left));
		int mid = (left + right) >> 1;
		TreeNode leftNode = buildBST(left, mid - 1);
		TreeNode rightNode = buildBST(mid + 1, right);
		return new TreeNode(values.get(mid), leftNode, rightNode);
	}
}

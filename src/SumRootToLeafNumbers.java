/**
 * Description: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode node, int val) {
		if (node.left == null && node.right == null) {
			return val * 10 + node.val;
		} else if (node.left == null) {
			return sumNumbers(node.right, val * 10 + node.val);
		} else if (node.right == null) {
			return sumNumbers(node.left, val * 10 + node.val);
		}
		return sumNumbers(node.left, val * 10 + node.val)
			+ sumNumbers(node.right, val * 10 + node.val);
	}
}

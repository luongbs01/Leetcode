/**
 * Description: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */

public class SumOfRootToLeafBinaryNumbers {

	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	private int sumRootToLeaf(TreeNode node, int val) {
		if (node.left == null && node.right == null) {
			return (val << 1) | node.val;
		} else if (node.left == null) {
			return sumRootToLeaf(node.right, (val << 1) | node.val);
		} else if (node.right == null) {
			return sumRootToLeaf(node.left, (val << 1) | node.val);
		}
		return sumRootToLeaf(node.left, (val << 1) | node.val)
			+ sumRootToLeaf(node.right, (val << 1) | node.val);
	}
}

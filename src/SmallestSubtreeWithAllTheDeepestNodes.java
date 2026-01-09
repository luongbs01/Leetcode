import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 */

public class SmallestSubtreeWithAllTheDeepestNodes {

	HashMap<TreeNode, TreeNode> parent = new HashMap<>();

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		parent.put(root, null);
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		TreeNode leftMost = null, rightMost = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0) {
					leftMost = node;
				}
				if (i == size - 1) {
					rightMost = node;
				}
				if (node.left != null) {
					parent.put(node.left, node);
					queue.offer(node.left);
				}
				if (node.right != null) {
					parent.put(node.right, node);
					queue.offer(node.right);
				}
			}
		}
		while (leftMost != rightMost) {
			leftMost = parent.get(leftMost);
			rightMost = parent.get(rightMost);
		}
		return leftMost;
	}
}

import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */

public class MaximumLevelSumOfABinaryTree {

	public int maxLevelSum(TreeNode root) {
		int ans = 1, level = 1, max = root.val;
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size(), sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (sum > max) {
				max = sum;
				ans = level;
			}
			level++;
		}
		return ans;
	}
}

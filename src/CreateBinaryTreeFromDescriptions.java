import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: https://leetcode.com/problems/create-binary-tree-from-descriptions/
 */

public class CreateBinaryTreeFromDescriptions {

	public TreeNode createBinaryTree(int[][] descriptions) {
		HashMap<Integer, TreeNode> nodes = new HashMap<>();
		HashSet<Integer> children = new HashSet<>();
		for (int[] description : descriptions) {
			int parent = description[0];
			int child = description[1];
			boolean isLeft = description[2] == 1;
			children.add(child);
			TreeNode parentNode = nodes.getOrDefault(parent, new TreeNode(parent));
			TreeNode childNode = nodes.getOrDefault(child, new TreeNode(child));
			if (isLeft) {
				parentNode.left = childNode;
			} else {
				parentNode.right = childNode;
			}
			nodes.put(parent, parentNode);
			nodes.put(child, childNode);
		}
		for (int[] description : descriptions) {
			if (!children.contains(description[0])) {
				return nodes.get(description[0]);
			}
		}
		return null;
	}
}

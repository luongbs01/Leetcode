/**
 * Description: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        if (node.val < max) {
            return dfs(node.left, max) + dfs(node.right, max);
        } else {
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        }
    }
}

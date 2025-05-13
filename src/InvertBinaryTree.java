/**
 * Description: https://leetcode.com/problems/invert-binary-tree/description/
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node != null && (node.left != null || node.right != null)) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                invert(node.left);
            }
            if (node.right != null) {
                invert(node.right);
            }
        }
    }
}

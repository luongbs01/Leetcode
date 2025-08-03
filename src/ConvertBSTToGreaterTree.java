/**
 * Description: https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */

public class ConvertBSTToGreaterTree {

    int value = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        value += node.val;
        node.val = value;
        dfs(node.left);
    }
}

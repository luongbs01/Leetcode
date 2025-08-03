/**
 * Description: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 */


public class BinarySearchTreeToGreaterSumTree {

    int value = 0;

    public TreeNode bstToGst(TreeNode root) {
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

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

public class BinaryTreePreorderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        ans.add(node.val);
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
    }
}

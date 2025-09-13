import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

public class BinaryTreePostorderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
        ans.add(node.val);
    }
}

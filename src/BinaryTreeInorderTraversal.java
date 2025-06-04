import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */

public class BinaryTreeInorderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }

    public List<Integer> inorderTraversalV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean flag = true;
        while (!stack.isEmpty()) {
            while (stack.peek().left != null && flag) {
                stack.push(stack.peek().left);
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
                flag = true;
            } else {
                flag = false;
            }
        }
        return ans;
    }
}

import java.util.HashMap;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/diameter-of-binary-tree/description/
 */

public class DiameterOfBinaryTree {
    HashMap<TreeNode, Integer> depth = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int ans = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans = Math.max(ans, diameterOfNode(node));
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return ans;
    }

    public int diameterOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;
        if (!depth.containsKey(node.left)) {
            leftDepth = maxDepth(node.left);
            depth.put(node.left, leftDepth);
        }
        if (!depth.containsKey(node.right)) {
            rightDepth = maxDepth(node.right);
            depth.put(node.right, rightDepth);
        }
        return leftDepth + rightDepth;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    int ans = 0;

    public int diameterOfBinaryTreeV2(TreeNode root) {
        if (root == null) return 0;
        height(root);
        return ans;
    }

    private int height(TreeNode node) {
        int leftHeight = node.left != null ? height(node.left) + 1 : 0;
        int rightHeight = node.right != null ? height(node.right) + 1 : 0;
        ans = Math.max(ans, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
    }
}

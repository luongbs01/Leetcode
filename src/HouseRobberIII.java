import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/house-robber-iiI/description/
 */

public class HouseRobberIII {

    HashMap<TreeNode, Integer> dp1 = new HashMap<>(); // dp1[v]: not take v
    HashMap<TreeNode, Integer> dp2 = new HashMap<>(); // dp2[v]: take v

    public void robSubtree(TreeNode node) {
        if (node.left != null) robSubtree(node.left);
        if (node.right != null) robSubtree(node.right);
        int val = (node.left != null) ? Math.max(dp1.get(node.left), dp2.get(node.left)) : 0;
        val += (node.right != null) ? Math.max(dp1.get(node.right), dp2.get(node.right)) : 0;
        dp1.put(node, val);
        val = node.val;
        val += (node.left != null) ? dp1.get(node.left) : 0;
        val += (node.right != null) ? dp1.get(node.right) : 0;
        dp2.put(node, val);
    }

    public int rob(TreeNode root) {
        robSubtree(root);
        return Math.max(dp1.get(root), dp2.get(root));
    }
}

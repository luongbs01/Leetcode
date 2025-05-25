/**
 * Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val >= p.val && root.val <= q.val)
                || (root.val >= q.val && root.val <= p.val)) {
            return root;
        } else if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

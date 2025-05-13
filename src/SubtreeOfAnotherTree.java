/**
 * Description: https://leetcode.com/problems/subtree-of-another-tree/
 */

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean isSameTree = isSameTree(root, subRoot);
        if (isSameTree) {
            return true;
        } else {
            return (root.left != null && isSubtree(root.left, subRoot))
                    || (root.right != null && isSubtree(root.right, subRoot));
        }
    }

    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        } else if (tree1 == null || tree2 == null || tree1.val != tree2.val) {
            return false;
        } else {
            return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
        }
    }
}

/**
 * Description: https://leetcode.com/problems/sum-of-left-leaves/description/
 */

public class SumOfLeftLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        recursion(root);
        return sum;
    }

    private void recursion(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            } else {
                recursion(node.left);
            }
        }
        if (node.right != null) {
            recursion(node.right);
        }
    }
}

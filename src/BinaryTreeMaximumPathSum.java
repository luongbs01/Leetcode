/**
 * Description: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */

public class BinaryTreeMaximumPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxPathSumLeft = dfs(root.left);
        int maxPathSumRight = dfs(root.right);
        int max = Math.max(root.val,
                Math.max(root.val + maxPathSumLeft, root.val + maxPathSumRight));
        ans = Math.max(ans, Math.max(max, root.val + maxPathSumLeft + maxPathSumRight));
        System.out.println("max: " + max + ", ans: " + ans);
        return max;
    }
}

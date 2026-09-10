/**
 * Description: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */

public class CountNodesEqualToAverageOfSubtree {

    public int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        int totalSum = left.sum + right.sum + node.val;
        int totalCnt = left.nodeCnt + right.nodeCnt + 1;
        if (node.val == totalSum / totalCnt) {
            ans++;
        }
        return new Pair(totalCnt, totalSum);
    }

    private class Pair {
        int nodeCnt, sum;

        public Pair(int nodeCnt, int sum) {
            this.nodeCnt = nodeCnt;
            this.sum = sum;
        }
    }
}

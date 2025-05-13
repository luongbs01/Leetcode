import java.util.*;

/**
 * Description: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Queue<Pair> q = new ArrayDeque<>();
        int currLevel = 0;
        q.offer(new Pair(root, currLevel));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (level != currLevel) {
                ans.add(new LinkedList<>(l));
                l.clear();
                currLevel = level;
            }
            l.add(node.val);
            if (node.left != null) {
                q.offer(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, level + 1));
            }
        }
        ans.add(new LinkedList<>(l));
        return ans;
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(new LinkedList<>(l));
            l.clear();
        }
        return ans;
    }

    private static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans = queue.peekLast().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}

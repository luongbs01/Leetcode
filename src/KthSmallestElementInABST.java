import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */

public class KthSmallestElementInABST {

    List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }
}

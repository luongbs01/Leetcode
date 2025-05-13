import java.util.ArrayList;

/**
 * Description: https://leetcode.com/problems/validate-binary-search-tree/description/
 */

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        dfs(root, inOrder);
        for (int i = 0; i < inOrder.size() - 1; i++) {
            if (inOrder.get(i) >= inOrder.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }
}

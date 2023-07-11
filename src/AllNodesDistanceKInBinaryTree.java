import java.util.*;

/**
 * Description: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);
        visited.add(target.val);
        dfs(target.val, 0, k);
        return ans;
    }

    public void buildGraph(TreeNode child, TreeNode parent) {
        if (child != null && parent != null) {
            graph.computeIfAbsent(child.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(child.val);
        }
        if (child.left != null) {
            buildGraph(child.left, child);
        }
        if (child.right != null) {
            buildGraph(child.right, child);
        }
    }

    public void dfs(int val, int distance, int k) {
        if (distance == k) {
            ans.add(val);
            return;
        }
        for (int neighbor : graph.getOrDefault(val, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

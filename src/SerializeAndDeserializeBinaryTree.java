import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root == null ? new TreeNode(1111) : root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val != 1111) {
                    list.add(node.val);
                } else {
                    list.add(null);
                    continue;
                }
                queue.offer(Objects.requireNonNullElseGet(node.left, () -> new TreeNode(1111)));
                queue.offer(Objects.requireNonNullElseGet(node.right, () -> new TreeNode(1111)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer);
            stringBuilder.append(',');
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        if ("null".equals(data)) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode node = queue.poll();
            if (!"null".equals(nodes[index])) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (!"null".equals(nodes[index])) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return root;
    }
}

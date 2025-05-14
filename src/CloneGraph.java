import java.util.*;

/**
 * Description: https://leetcode.com/problems/clone-graph/description/
 */

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cloned = new Node(node.val);
        Set<String> visitedEdges = new HashSet<>();
        Map<Integer, Node> clonedNodes = new HashMap<>();
        clonedNodes.put(cloned.val, cloned);
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            List<Node> neighbors = curr.neighbors;
            neighbors.forEach(neighbor -> {
                if (!clonedNodes.containsKey(neighbor.val)) {
                    Node newNode = new Node(neighbor.val);
                    clonedNodes.put(neighbor.val, newNode);
                    queue.offer(neighbor);
                }
                int[] edge = new int[]{curr.val, neighbor.val};
                Arrays.sort(edge);
                if (!visitedEdges.contains(Arrays.toString(edge))) {
                    clonedNodes.get(curr.val).neighbors.add(clonedNodes.get(neighbor.val));
                    clonedNodes.get(neighbor.val).neighbors.add(clonedNodes.get(curr.val));
                    visitedEdges.add(Arrays.toString(edge));
                }
            });
        }
        return cloned;
    }


    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

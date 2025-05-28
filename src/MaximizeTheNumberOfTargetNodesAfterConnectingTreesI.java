import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
 */

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adjList1 = new ArrayList<>(n);
        List<List<Integer>> adjList2 = new ArrayList<>(m);
        for (int i = 0; i < n; i++) {
            adjList1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adjList2.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            adjList1.get(edge[0]).add(edge[1]);
            adjList1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            adjList2.get(edge[0]).add(edge[1]);
            adjList2.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[n];
        int plus = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = bfs(i, k, n, adjList1);
        }
        for (int i = 0; i < m; i++) {
            plus = Math.max(plus, bfs(i, k - 1, m, adjList2));
        }
        for (int i = 0; i < n; i++) {
            ans[i] += plus;
        }
        return ans;
    }

    private int bfs(int i, int k, int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];
        visited[i] = true;
        int count = 0;
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        while (!queue.isEmpty() && count <= k) {
            int size = queue.size();
            count++;
            for (int j = 0; j < size; j++) {
                int l = queue.poll();
                ans++;
                adjList.get(l).forEach(adj -> {
                    if (!visited[adj]) {
                        visited[adj] = true;
                        queue.offer(adj);
                    }
                });
            }
        }
        return ans;
    }
}

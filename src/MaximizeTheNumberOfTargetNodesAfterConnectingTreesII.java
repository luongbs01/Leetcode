import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/
 */

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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
        boolean[] tree1 = bfs(n, adjList1);
        boolean[] tree2 = bfs(m, adjList2);
        int countTrue1 = 0, countFalse1 = 0;
        int countTrue2 = 0, countFalse2 = 0;
        for (boolean b : tree1) {
            if (b) {
                countTrue1++;
            } else {
                countFalse1++;
            }
        }
        for (boolean b : tree2) {
            if (b) {
                countTrue2++;
            } else {
                countFalse2++;
            }
        }
        int max = Math.max(countTrue2, countFalse2);
        int true1 = countTrue1 + max;
        int false1 = countFalse1 + max;
        for (int i = 0; i < n; i++) {
            if (tree1[i]) {
                ans[i] = true1;
            } else {
                ans[i] = false1;
            }
        }
        return ans;
    }

    private boolean[] bfs(int n, List<List<Integer>> adjList) {
        boolean[] ans = new boolean[n];
        ans[0] = true;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                adjList.get(j).forEach(adj -> {
                    if (!visited[adj]) {
                        visited[adj] = true;
                        ans[adj] = !ans[j];
                        queue.offer(adj);
                    }
                });
            }
        }
        return ans;
    }
}

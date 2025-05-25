import java.util.*;

/**
 * Description: https://leetcode.com/problems/redundant-connection/description/
 */

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int v = edges.length;
        List<List<Integer>> adjList = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v + 1];
        int[] trace = new int[v + 1];
        Set<Integer> cycle = new HashSet<>();
        stack.add(1);
        visited[1] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int adj : adjList.get(node)) {
                if (trace[node] == adj) {
                    continue;
                }
                if (!visited[adj]) {
                    visited[adj] = true;
                    stack.push(adj);
                    trace[adj] = node;
                } else { // cycle found
                    cycle.add(adj);
                    cycle.add(trace[adj]);
                    while (node != trace[adj]) {
                        cycle.add(node);
                        node = trace[node];
                    }
                    stack.clear();
                    break;
                }
            }
        }
        for (int i = v - 1; i >= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[0];
    }

    int[] parent;
    int[] rank;

    public int[] findRedundantConnectionV2(int[][] edges) {
        int v = edges.length;
        parent = new int[v + 1];
        rank = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int v) {
        if (v == parent[v]) {
            return v;
        }
        int p = find(parent[v]);
        parent[v] = p;
        return p;
    }

    private boolean union(int u, int v) {
        int pU = find(u);
        int pV = find(v);
        if (pU == pV) {
            return false;
        }
        if (pU < pV) {
            int temp = pU;
            pU = pV;
            pV = temp;
        }
        parent[pV] = pU;
        if (rank[pU] == rank[pV]) {
            rank[pU]++;
        }
        return true;
    }
}

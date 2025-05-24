import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */

public class MinCostToConnectAllPoints {
    int[] parent;
    int[] rank;

    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        if (v == 2) {
            return Math.abs(points[0][0] - points[1][0]) + Math.abs(points[0][1] - points[1][1]);
        }
        int e = v * (v - 1) / 2;
        parent = new int[e];
        rank = new int[e];
        for (int i = 0; i < e; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int[][] edges = new int[e][3];
        int count = 0;
        for (int i = 0; i < v - 1; i++) {
            for (int j = i + 1; j < v; j++) {
                edges[count] = new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])};
                count++;
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        int ans = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                ans += edge[2];
            }
        }
        return ans;
    }

    private boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU == parentV) {
            return false;
        }
        if (rank[parentU] < rank[parentV]) {
            int temp = parentU;
            parentU = parentV;
            parentV = temp;
        }
        parent[parentV] = parentU;
        if (rank[parentU] == rank[parentV]) {
            rank[parentU]++;
        }
        return true;
    }

    private int find(int v) {
        if (v == parent[v]) return v;
        int p = find(parent[v]);
        parent[v] = p;
        return p;
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
 */

public class LargestColorValueInADirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        char[] charColor = colors.toCharArray();
        int[] inDeg = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            inDeg[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        Integer[] arr = queue.toArray(new Integer[0]);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int adj : adjList.get(v)) {
                inDeg[adj]--;
                if (inDeg[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDeg[i] > 0) {
                return -1;
            }
        }
        int[][] max = new int[n][26];
        int ans = 1;
        for (int i : arr) {
            max[i][charColor[i] - 'a'] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int adj : adjList.get(v)) {
                    boolean canImprove = false;
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (max[adj][c - 'a'] <= max[v][c - 'a']) {
                            if (max[adj][c - 'a'] < max[v][c - 'a']) {
                                max[adj][c - 'a'] = max[v][c - 'a'];
                                canImprove = true;
                            }
                            if (charColor[adj] == c) {
                                max[adj][c - 'a'] = max[v][c - 'a'] + 1;
                                ans = Math.max(ans, max[adj][c - 'a']);
                                canImprove = true;
                            }
                        }
                    }
                    if (canImprove) {
                        queue.offer(adj);
                    }
                }
            }
        }
        return ans;
    }
}

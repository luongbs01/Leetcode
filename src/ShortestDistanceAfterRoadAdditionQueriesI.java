import java.util.*;

/**
 * Description: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/
 */

public class ShortestDistanceAfterRoadAdditionQueriesI {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int length = queries.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i + 1);
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            adjList.get(queries[i][0]).add(queries[i][1]);
            ans[i] = bfs(n, adjList);
        }
        return ans;
    }

    private int bfs(int n, List<List<Integer>> adjList) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                if (j == n - 1) {
                    return count;
                }
                for (int k : adjList.get(j)) {
                    if (!visited[k]) {
                        queue.offer(k);
                        visited[k] = true;
                    }
                }
            }
        }
        return count;
    }
}

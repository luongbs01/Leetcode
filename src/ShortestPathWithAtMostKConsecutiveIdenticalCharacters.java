import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/
 */

public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        char[] chars = labels.toCharArray();
        List<int[]>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        boolean[][] visited = new boolean[n][k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{0, 0, chars[0] - 'a', 1});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (node[0] == n - 1 && node[3] <= k) {
                return node[1];
            }
            if (!visited[node[0]][node[3]]) {
                visited[node[0]][node[3]] = true;
                for (int[] adj : adjList[node[0]]) {
                    int cnt = chars[node[0]] == chars[adj[0]] ? node[3] + 1 : 1;
                    if (cnt <= k && !visited[adj[0]][cnt]) {
                        pq.add(new int[]{adj[0], node[1] + adj[1], chars[adj[0]], cnt});
                    }
                }
            }
        }
        return -1;
    }
}

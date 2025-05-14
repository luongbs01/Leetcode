import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/pacific-atlantic-water-flow/
 */

public class PacificAtlanticWaterFlow {

    List<List<Integer>> ans = new LinkedList<>();
    int m, n;
    int[][] ways = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(i, j, heights)) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private boolean bfs(int i, int j, int[][] heights) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        boolean reachPacific = i == 0 || j == 0;
        boolean reachAtlantic = i == m - 1 || j == n - 1;
        int nextX, nextY;
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] way : ways) {
                nextX = curr[0] + way[0];
                nextY = curr[1] + way[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
                        heights[nextX][nextY] <= heights[curr[0]][curr[1]]) {
                    reachPacific = reachPacific || nextX == 0 || nextY == 0;
                    reachAtlantic = reachAtlantic || nextX == m - 1 || nextY == n - 1;
                    if (reachPacific && reachAtlantic) {
                        return true;
                    }
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return reachPacific && reachAtlantic;
    }
}

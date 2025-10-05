import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/pacific-atlantic-water-flow/
 */

public class PacificAtlanticWaterFlow {

    int m, n;
    int[][] heights;
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] pacific, atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});
            atlantic[i][n - 1] = true;
            atlanticQueue.offer(new int[]{i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            pacific[0][i] = true;
            pacificQueue.offer(new int[]{0, i});
            atlantic[m - 1][i] = true;
            atlanticQueue.offer(new int[]{m - 1, i});
        }
        bfs(pacific, pacificQueue);
        bfs(atlantic, atlanticQueue);
        List<List<Integer>> ans = new ArrayList<>(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(boolean[][] map, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : directions) {
                int x = cell[0] + direction[0];
                int y = cell[1] + direction[1];
                if (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1 && !map[x][y] && heights[cell[0]][cell[1]] <= heights[x][y]) {
                    map[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}

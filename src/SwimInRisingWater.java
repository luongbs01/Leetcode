import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/swim-in-rising-water/
 */

public class SwimInRisingWater {
    int n;
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        n = grid.length;
        int l = grid[0][0], r = n * n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (bfs(mid, grid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean bfs(int maxTime, int[][] grid) {
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction : directions) {
                int nextX = curr[0] + direction[0];
                int nextY = curr[1] + direction[1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY] && grid[nextX][nextY] <= maxTime) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return visited[n - 1][n - 1];
    }
}

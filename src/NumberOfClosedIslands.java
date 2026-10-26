import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/number-of-closed-islands/description/
 */

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (m < 3 || n < 3) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    boolean valid = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        if (arr[0] == 0 || arr[0] == m - 1 || arr[1] == 0 || arr[1] == n - 1) {
                            valid = false;
                        }
                        if (!visited[arr[0]][arr[1]]) {
                            visited[arr[0]][arr[1]] = true;
                            for (int[] direction : directions) {
                                int nextX = arr[0] + direction[0];
                                int nextY = arr[1] + direction[1];
                                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                                        && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                                    queue.offer(new int[]{nextX, nextY});
                                }
                            }
                        }
                    }
                    ans += valid ? 1 : 0;
                }
            }
        }
        return ans;
    }
}

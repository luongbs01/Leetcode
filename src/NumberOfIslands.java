import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/number-of-islands/
 */

public class NumberOfIslands {
    int m, n;
    boolean[][] visited;
    int[][] moves;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    bfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] v = q.poll();
            for (int[] move : moves) {
                int row = v[0] + move[0];
                int col = v[1] + move[1];
                if (row >= 0 && row < m
                        && col >= 0 && col < n
                        && grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    q.offer(new int[]{row, col});
                }
            }
        }
    }
}

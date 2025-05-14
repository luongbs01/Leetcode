import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/surrounded-regions/
 */

public class SurroundedRegions {

    int m, n;
    boolean[][] visited;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                bfs(i, n - 1, board);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if (board[m - 1][i] == 'O') {
                bfs(m - 1, i, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int i, int j, char[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction : directions) {
                int nextX = curr[0] + direction[0];
                int nextY = curr[1] + direction[1];
                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}

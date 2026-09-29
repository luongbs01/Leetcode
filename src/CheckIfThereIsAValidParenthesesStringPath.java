import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 */

public class CheckIfThereIsAValidParenthesesStringPath {

    public boolean hasValidPath(char[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '('
                || ((m + n - 1) & 1) != 0) return false;

        boolean[][] visited = new boolean[m * n][m + n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int x = head[0], y = head[1], score = head[2];
            if (x == m - 1 && y == n - 1 && score == 0) {
                return true;
            }
            if (!visited[x * n + y][score]) {
                visited[x * n + y][score] = true;
                for (int[] direction : directions) {
                    int nextX = x + direction[0], nextY = y + direction[1];
                    if (nextX < m && nextY < n) {
                        int nextScore = score + (grid[nextX][nextY] == '(' ? 1 : -1);
                        if (nextScore >= 0 && nextScore <= (m + n - nextX - nextY)
                                && !visited[nextX * n + nextY][nextScore]) {
                            queue.offer(new int[]{nextX, nextY, nextScore});
                        }
                    }
                }
            }
        }
        return false;
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/
 */

public class CountIslandsWithTotalValueDivisibleByK {

    public int countIslands(int[][] grid, int k) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    long sum = grid[i][j];
                    grid[i][j] = -1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] currPos = queue.poll();
                        int currX = currPos[0], currY = currPos[1];
                        for (int[] direction : directions) {
                            int nextX = currX + direction[0], nextY = currY + direction[1];
                            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] > 0) {
                                sum += grid[nextX][nextY];
                                grid[nextX][nextY] = -1;
                                queue.offer(new int[]{nextX, nextY});
                            }
                        }
                    }
                    if (sum % k == 0) ans++;
                }
            }
        }
        return ans;
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/path-with-minimum-effort/description/
 */

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        boolean[] inQueue = new boolean[rows * cols];
        inQueue[0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            inQueue[curr[0] * cols + curr[1]] = false;
            for (int[] direction : directions) {
                int nextX = curr[0] + direction[0];
                int nextY = curr[1] + direction[1];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                    int currMax = Math.max(effort[curr[0]][curr[1]], Math.abs(heights[nextX][nextY] - heights[curr[0]][curr[1]]));
                    if (effort[nextX][nextY] > currMax) {
                        effort[nextX][nextY] = currMax;
                        queue.offer(new int[]{nextX, nextY});
                        inQueue[nextX * cols + nextY] = true;
                    }
                }
            }
        }
        return effort[rows - 1][cols - 1];
    }
}

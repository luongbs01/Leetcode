import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/trapping-rain-water-ii/
 */

public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heightMap.length, n = heightMap[0].length, ans = 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            pq.offer(new int[]{heightMap[0][i], 0, i});
            pq.offer(new int[]{heightMap[m - 1][i], m - 1, i});
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int v = arr[0], x = arr[1], y = arr[2];
            for (int[] direction : directions) {
                int newX = x + direction[0], newY = y + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    if (heightMap[newX][newY] < v) {
                        ans += (v - heightMap[newX][newY]);
                        heightMap[newX][newY] = v;
                    }
                    visited[newX][newY] = true;
                    pq.offer(new int[]{heightMap[newX][newY], newX, newY});
                }
            }
        }
        return ans;
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/k-closest-points-to-origin/description/
 */

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int[] point : points) {
            pq.offer(new int[]{point[0], point[1], point[0] * point[0] + point[1] * point[1]});
        }
        int[][] ans = new int[k][2];
        k--;
        while (k >= 0) {
            ans[k] = new int[]{pq.peek()[0], pq.peek()[1]};
            pq.poll();
            k--;
        }
        return ans;
    }

    public int[][] kClosestV2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, Comparator.comparingInt(o -> -o[2]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            if (pq.size() < k) {
                pq.offer(new int[]{point[0], point[1], dist});
            } else if (pq.peek()[2] > dist) {
                pq.poll();
                pq.offer(new int[]{point[0], point[1], dist});
            }
        }
        int[][] ans = new int[k][2];
        k--;
        while (k >= 0) {
            ans[k] = new int[]{pq.peek()[0], pq.peek()[1]};
            pq.poll();
            k--;
        }
        return ans;
    }
}

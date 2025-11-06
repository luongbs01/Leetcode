import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/power-grid-maintenance/description/
 */

public class PowerGridMaintenance {

    int[] rank;
    boolean[] nonOperational;
    HashMap<Integer, PriorityQueue<Integer>> map;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        this.rank = new int[c + 1];
        this.nonOperational = new boolean[c + 1];
        map = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            rank[i] = i;
        }
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        for (int i = 1; i <= c; i++) {
            if (rank[i] == i) {
                map.putIfAbsent(i, new PriorityQueue<>());
                map.get(i).offer(i);
            } else {
                map.get(find(i)).offer(i);
            }
        }
        int cnt = 0;
        for (int[] query : queries) {
            if (query[0] == 1) cnt++;
        }
        int[] ans = new int[cnt];
        cnt = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                ans[cnt] = getOperational(query[1]);
                cnt++;
            } else {
                nonOperational[query[1]] = true;
            }
        }

        return ans;
    }

    private void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 != p2) {
            int min = Math.min(p1, p2);
            int max = Math.max(p1, p2);
            rank[max] = min;
        }
    }

    private int getOperational(int i) {
        if (!nonOperational[i]) return i;
        PriorityQueue<Integer> pq = map.get(find(i));
        while (!pq.isEmpty() && nonOperational[pq.peek()]) {
            pq.poll();
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }

    private int find(int i) {
        if (rank[i] == i) return i;
        int parent = find(rank[i]);
        rank[i] = parent;
        return parent;
    }
}

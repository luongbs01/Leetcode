import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
 */

public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        int node = node1;
        int count = 0;
        while (node != -1 && dist1[node] == -1) {
            dist1[node] = count;
            count++;
            node = edges[node];
        }
        node = node2;
        count = 0;
        while (node != -1 && dist2[node] == -1) {
            dist2[node] = count;
            count++;
            node = edges[node];
        }
        int ans = -1;
        int maxDist;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < min) {
                    min = maxDist;
                    ans = i;
                }
            }
        }
        return ans;
    }
}

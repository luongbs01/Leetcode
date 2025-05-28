/**
 * Description: https://leetcode.com/problems/node-with-highest-edge-score/description/
 */

public class NodeWithHighestEdgeScore {

    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
            if (score[edges[i]] > max) {
                max = score[edges[i]];
            }
        }
        for (int i = 0; i < n; i++) {
            if (score[i] == max) {
                return i;
            }
        }
        return 0;
    }
}

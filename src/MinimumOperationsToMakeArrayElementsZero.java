/**
 * Description: https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/description/
 */

public class MinimumOperationsToMakeArrayElementsZero {

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] query : queries) {
            long start = query[0], end = query[1];
            long ops = 0;
            for (long d = 1, prev = 1; d < 17; d++) {
                long cur = prev * 4;
                // Find the intersection between the query interval [start, end] and [prev, cur - 1]
                long l = Math.max(start, prev);
                long r = Math.min(end, cur - 1);
                if (r >= l) {
                    ops += (r - l + 1) * d;
                }
                prev = cur;
            }
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}

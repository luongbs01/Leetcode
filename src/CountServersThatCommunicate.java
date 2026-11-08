/**
 * Description: https://leetcode.com/problems/count-servers-that-communicate/
 */

public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int[] row : grid) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (row[i] == 1) ? 1 : 0;
            }
            if (cnt > 1) {
                for (int i = 0; i < n; i++) {
                    row[i] <<= 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int[] row : grid) {
                cnt += (row[i] > 0) ? 1 : 0;
            }
            if (cnt > 1) {
                for (int[] row : grid) {
                    row[i] <<= 1;
                }
            }
        }

        for (int[] row : grid) {
            for (int i : row) {
                ans += (i > 1) ? 1 : 0;
            }
        }
        return ans;
    }
}

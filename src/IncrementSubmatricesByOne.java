/**
 * Description: https://leetcode.com/problems/increment-submatrices-by-one/
 */

public class IncrementSubmatricesByOne {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n], ans = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                diff[i][query[1]]++;
                if (query[3] + 1 < n)
                    diff[i][query[3] + 1]--;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i][0] = diff[i][0];
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i][j - 1] + diff[i][j];
            }
        }
        return ans;
    }
}

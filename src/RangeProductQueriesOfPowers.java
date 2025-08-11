import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/range-product-queries-of-powers/description/
 */

public class RangeProductQueriesOfPowers {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                list.add(1 << i);
            }
        }
        n = list.size();
        long[][] product = new long[n][n];
        for (int i = 0; i < n; i++) {
            product[i][i] = list.get(i);
            for (int j = i + 1; j < n; j++) {
                product[i][j] = (product[i][j - 1] * list.get(j)) % 1000000007;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (int) product[queries[i][0]][queries[i][1]];
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 */

public class WaysToExpressAnIntegerAsSumOfPowers {

    public int numberOfWays(int n, int x) {
        List<Integer> list = new ArrayList<>();
        int k = 1;
        while (Math.pow(k, x) <= n) {
            list.add((int) Math.pow(k, x));
            k++;
        }
        k = list.size();
        // dp[i][j]: number of ways to sum to j using first i elements
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] % 1000000007;
                if (j - list.get(i - 1) >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - list.get(i - 1)]) % 1000000007;
            }
        }
        return (int) dp[k][n];
    }
}

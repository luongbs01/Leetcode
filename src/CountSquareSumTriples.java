/**
 * Description: https://leetcode.com/problems/count-square-sum-triples/
 */

public class CountSquareSumTriples {

    public int countTriples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double sum = i * i + j * j;
                int sqrt = (int) Math.sqrt(sum);
                if (sum == sqrt * sqrt && sqrt <= n) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

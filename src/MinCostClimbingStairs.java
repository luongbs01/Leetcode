/**
 * Description: https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCostAt = new int[len + 1];
        minCostAt[0] = 0;
        minCostAt[1] = 0;
        for (int i = 2; i <= len; i++) {
            minCostAt[i] = Math.min((minCostAt[i - 1] + cost[i - 1]), (minCostAt[i - 2] + cost[i - 2]));
        }
        return minCostAt[len];
    }
}

/**
 * Description: https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] minCostAt = new int[length + 1];
        minCostAt[0] = minCostAt[1] = 0;
        for (int i = 2; i <= length; i++) {
            minCostAt[i] = Math.min(minCostAt[i - 2] + cost[i - 2], minCostAt[i - 1] + cost[i - 1]);
        }
        return minCostAt[length];
    }
}

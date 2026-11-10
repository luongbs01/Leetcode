/**
 * Description: https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 */

public class MinimumCostToAcquireRequiredItems {

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = Long.MAX_VALUE;
        long maxNeed = Math.max(need1, need2);
        long minNeed = Math.min(need1, need2);
        ans = Math.min(ans, maxNeed * costBoth);
        ans = Math.min(ans, minNeed * costBoth + (need1 - minNeed) * cost1 + (need2 - minNeed) * cost2);
        ans = Math.min(ans, (long) need1 * cost1 + (long) need2 * cost2);
        return ans;
    }
}

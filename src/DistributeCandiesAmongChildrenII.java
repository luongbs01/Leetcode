/**
 * Description: https://leetcode.com/problems/distribute-candies-among-children-ii/description/
 */

public class DistributeCandiesAmongChildrenII {

    public long distributeCandies(int n, int limit) {
        long ans = 0;
        int min = Math.max(0, n - 2 * limit);
        int max = Math.min(n, limit);
        for (int i = min; i <= max; i++) {
            ans += distributeCandiesForTwoChildren(n - i, limit);
        }
        return ans;
    }

    private long distributeCandiesForTwoChildren(int k, int limit) {
        if (k <= limit)
            return k + 1;
        if (k == limit * 2)
            return 1;
        return 2 * limit - k + 1;
    }
}

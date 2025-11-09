/**
 * Description: https://leetcode.com/problems/add-minimum-number-of-rungs/
 */


public class AddMinimumNumberOfRungs {

    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length, ans = (rungs[0] - 1) / dist;
        for (int i = 1; i < n; i++) {
            ans += (rungs[i] - rungs[i-1] - 1) / dist;
        }
        return ans;
    }
}

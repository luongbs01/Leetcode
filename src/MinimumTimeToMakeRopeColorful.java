/**
 * Description: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */

public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int ans = 0, max = neededTime[0], total = neededTime[0], n = colors.length();
        char[] chars = colors.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                ans += total - max;
                max = neededTime[i];
                total = neededTime[i];
            } else {
                max = Math.max(max, neededTime[i]);
                total += neededTime[i];
            }
        }
        return ans + (total - max);
    }
}

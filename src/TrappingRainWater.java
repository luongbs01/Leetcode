/**
 * Description: https://leetcode.com/problems/trapping-rain-water/description/
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0, max = 0, n = height.length;
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            ans += Math.min(leftMax[i], max) - height[i];
        }
        return ans;
    }
}

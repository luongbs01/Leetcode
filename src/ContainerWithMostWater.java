/**
 * Description: https://leetcode.com/problems/container-with-most-water/description/
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = (j - i) * Math.min(height[i], height[j]);
        while (i < j) {
            if (height[i] <= height[j]) {
                while (i < j && height[i] <= height[j]) {
                    i++;
                    res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
                }
            }
            if (height[i] >= height[j]) {
                while (i < j && height[i] >= height[j]) {
                    j--;
                    res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
                }
            }
        }

        return res;
    }

    public int maxAreaOptimized(int[] height) {
        int i = 0, j = height.length - 1;
        int res = (j - i) * Math.min(height[i], height[j]);
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}

/**
 * Description: https://leetcode.com/problems/maximal-rectangle/description/
 */

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[] height = new int[n];
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                    int minHeight = height[j];
                    for (int k = j; k >= 0 && minHeight > 0; k--) {
                        minHeight = Math.min(minHeight, height[k]);
                        ans = Math.max(ans, (j - k + 1) * minHeight);
                    }
                }
            }
        }
        return ans;
    }
}

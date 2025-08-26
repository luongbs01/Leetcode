/**
 * Description: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/
 */

public class MaximumAreaOfLongestDiagonalRectangle {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0, max = 0;
        for (int[] dimension : dimensions) {
            int diagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (diagonal > max) {
                max = diagonal;
                ans = dimension[0] * dimension[1];
            } else if (diagonal == max) {
                ans = Math.max(ans, dimension[0] * dimension[1]);
            }
        }
        return ans;
    }
}

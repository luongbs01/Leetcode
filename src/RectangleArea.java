/**
 * Description: https://leetcode.com/problems/rectangle-area/
 */

public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int[] bottomLeft = new int[2];
        int[] topRight = new int[2];
        bottomLeft[0] = Math.max(ax1, bx1);
        bottomLeft[1] = Math.max(ay1, by1);
        topRight[0] = Math.min(ax2, bx2);
        topRight[1] = Math.min(ay2, by2);
        int ans = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (topRight[0] >= bottomLeft[0] && topRight[1] >= bottomLeft[1]) {
            return ans - (topRight[0] - bottomLeft[0]) * (topRight[1] - bottomLeft[1]);
        }
        return ans;
    }
}

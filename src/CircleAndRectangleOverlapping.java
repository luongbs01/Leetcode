/**
 * Description: https://leetcode.com/problems/circle-and-rectangle-overlapping/
 */

public class CircleAndRectangleOverlapping {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        for (int i = x1; i <= x2; i++) {
            if (Math.sqrt(Math.pow(i - xCenter, 2) + Math.pow(y1 - yCenter, 2)) <= radius
                    || Math.sqrt(Math.pow(i - xCenter, 2) + Math.pow(y2 - yCenter, 2)) <= radius) {
                return true;
            }
        }
        for (int i = y1; i <= y2; i++) {
            if (Math.sqrt(Math.pow(x1 - xCenter, 2) + Math.pow(i - yCenter, 2)) <= radius
                    || Math.sqrt(Math.pow(x2 - xCenter, 2) + Math.pow(i - yCenter, 2)) <= radius) {
                return true;
            }
        }
        return false;
    }
}

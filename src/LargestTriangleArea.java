/**
 * Description: https://leetcode.com/problems/largest-triangle-area/
 */

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] point1, int[] point2, int[] point3) {
        double x = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
        double y = Math.sqrt(Math.pow(point2[0] - point3[0], 2) + Math.pow(point2[1] - point3[1], 2));
        double z = Math.sqrt(Math.pow(point1[0] - point3[0], 2) + Math.pow(point1[1] - point3[1], 2));
        double p = (x + y + z) / 2;
        double s = p * (p - x) * (p - y) * (p - z);
        return s > 0 ? Math.sqrt(s) : 0;
    }
}

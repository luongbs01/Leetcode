import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] leftNearestLess = getLeftDistanceFromNearestLess(heights);
        int[] rightNearestLess = getRightDistanceFromNearestLess(heights);
        System.out.println(Arrays.toString(leftNearestLess));
        System.out.println(Arrays.toString(rightNearestLess));
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * (rightNearestLess[i] + leftNearestLess[i] - 1));
        }
        return ans;
    }

    private int[] getLeftDistanceFromNearestLess(int[] heights) {
        int length = heights.length;
        int[] ans = new int[length];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { Integer.MIN_VALUE, -1 });
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            // mono increasing stack => find nearest element that is less than current element
            while (height <= stack.peek()[0]) {
                stack.pop();
            }
            ans[i] = i - stack.peek()[1];
            stack.push(new int[] { height, i });
        }
        return ans;
    }

    private int[] getRightDistanceFromNearestLess(int[] heights) {
        int length = heights.length;
        int[] ans = new int[length];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { Integer.MIN_VALUE, heights.length });
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            while (height <= stack.peek()[0]) {
                stack.pop();
            }
            ans[i] = stack.peek()[1] - i;
            stack.push(new int[] { height, i });
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}

import java.util.*;

/**
 * Description: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] leftNearestLess = getDistanceFromNearestLess(heights);
        List<Integer> list = new ArrayList<>(Arrays.stream(heights).boxed().toList());
        Collections.reverse(list);
        int[] rightNearestLess = getDistanceFromNearestLess(list.stream().mapToInt(i -> i).toArray());
        list = new ArrayList<>(Arrays.stream(rightNearestLess).boxed().toList());
        Collections.reverse(list);
        rightNearestLess = list.stream().mapToInt(i -> i).toArray();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * (leftNearestLess[i] + rightNearestLess[i] - 1));
        }
        return ans;
    }

    private int[] getDistanceFromNearestLess(int[] heights) {
        int length = heights.length;
        int[] ans = new int[length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.MIN_VALUE, -1});
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            while (height <= stack.peek()[0]) {
                stack.pop();
            }
            ans[i] = i - stack.peek()[1];
            stack.push(new int[]{height, i});
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}

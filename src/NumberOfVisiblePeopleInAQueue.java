import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
 */

public class NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                count++;
            }
            ans[i] = stack.isEmpty() ? count - 1 : count;
            stack.push(i);
        }
        return ans;
    }

}

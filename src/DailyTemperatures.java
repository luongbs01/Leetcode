import java.util.Map;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/daily-temperatures/description/
 */

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        ans[length - 1] = 0;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        stack.push(Map.entry(temperatures[length - 1], length - 1));
        for (int i = length - 2; i >= 0; i--) {
            // mono decreasing stack => find nearest element that is greater than current element
            while (!stack.isEmpty() && temperatures[i] >= stack.peek().getKey()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek().getValue() - i;
            }
            stack.push(Map.entry(temperatures[i], i));
        }
        return ans;
    }
}

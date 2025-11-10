import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/daily-temperatures/description/
 */

public class DailyTemperatures {

    // 91ms
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

    // 25ms
    public int[] dailyTemperaturesV2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                ans[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return ans;
    }

    public int[] dailyTemperaturesV3(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}

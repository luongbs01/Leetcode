import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/min-stack/description/
 */

public class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, getMin());
        stack.push(new int[]{val, min});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

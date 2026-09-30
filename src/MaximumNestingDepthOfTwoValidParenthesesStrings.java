import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */

public class MaximumNestingDepthOfTwoValidParenthesesStrings {

    // 4ms
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        char[] chars = seq.toCharArray();
        int[] depth = new int[n];
        int[] pair = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                pair[i] = stack.pop();
                pair[pair[i]] = i;
                int max = 0;
                for (int startidx = pair[i] + 1; startidx < i; startidx = pair[startidx] + 1) {
                    max = Math.max(max, depth[startidx]);
                }
                depth[i] = max + 1;
                depth[pair[i]] = max + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            depth[i] &= 1;
        }
        return depth;
    }

    // 1ms
    public int[] maxDepthAfterSplitV2(String seq) {
        int n = seq.length(), depth = 0;
        char[] chars = seq.toCharArray();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                depth++;
                ans[i] = depth & 1;
            } else {
                ans[i] = depth & 1;
                depth--;
            }
        }
        return ans;
    }
}

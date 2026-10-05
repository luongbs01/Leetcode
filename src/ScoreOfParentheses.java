import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/score-of-parentheses/
 */

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        int n = s.length(), ans = 0;
        char[] chars = s.toCharArray();
        int[] pairs = new int[n];
        int[] score = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                pairs[i] = stack.pop();
                pairs[pairs[i]] = i;
                if (i - pairs[i] == 1) {
                    score[i] = score[pairs[i]] = 1;
                } else {
                    int sum = 0;
                    for (int startIdx = pairs[i] + 1; startIdx < i; startIdx = pairs[startIdx] + 1) {
                        sum += score[startIdx];
                    }
                    score[i] = score[pairs[i]] = sum << 1;
                }
            }
        }
        for (int startIdx = 0; startIdx < n; startIdx = pairs[startIdx] + 1) {
            ans += score[startIdx];
        }
        return ans;
    }
}

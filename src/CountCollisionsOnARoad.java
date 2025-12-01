import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/count-collisions-on-a-road/
 */

public class CountCollisionsOnARoad {

    public int countCollisions(String directions) {
        int ans = 0;
        char[] chars = directions.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c == 'R') {
                stack.push(c);
            } else if (c == 'S') {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    ans += 1;
                    stack.pop();
                }
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == 'S') {
                    ans += 1;
                } else if (!stack.isEmpty() && stack.peek() == 'R') {
                    ans += 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        ans += 1;
                        stack.pop();
                    }
                    stack.push('S');
                }
            }

        }
        return ans;
    }
}

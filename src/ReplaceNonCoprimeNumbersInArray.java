import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/
 */

public class ReplaceNonCoprimeNumbersInArray {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            int last = num;
            while (!stack.isEmpty()) {
                int gcd = GCD(stack.peek(), last);
                if (gcd <= 1)
                    break;
                last = last / gcd * stack.peek();
                stack.pop();
            }
            stack.push(last);
        }
        List<Integer> ans = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            ans.add(stack.pollLast());
        }
        return ans;
    }

    private int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b)
                a %= b;
            else
                b %= a;
        }
        return Math.max(a, b);
    }
}

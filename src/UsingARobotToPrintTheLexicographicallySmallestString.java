import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
 */

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String robotWithString(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for (char c : chars) {
            freq[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder(s.length());
        Deque<Character> stack = new ArrayDeque<>();
        int currChar = 0;
        for (char c : chars) {
            while (freq[currChar] == 0) {
                currChar++;
                while (!stack.isEmpty() && currChar >= stack.peek() - 'a') {
                    ans.append(stack.pop());
                }
            }
            if (c - 'a' == currChar) {
                ans.append(c);
            } else {
                stack.push(c);
            }
            freq[c - 'a']--;
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}

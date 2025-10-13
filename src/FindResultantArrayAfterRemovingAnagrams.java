import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */

public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            if (stack.empty() || !isAnagram(stack.peek(), word)) {
                stack.push(word);
            }
        }
        return stack;
    }

    private boolean isAnagram(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }
}

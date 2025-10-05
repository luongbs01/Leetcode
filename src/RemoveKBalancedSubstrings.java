/**
 * Description: https://leetcode.com/problems/remove-k-balanced-substrings/description/
 */

public class RemoveKBalancedSubstrings {

    public String removeSubstring(String s, int k) {
        StringBuilder stack = new StringBuilder();
        String toRemove = "(".repeat(k) + ")".repeat(k);

        for (char c : s.toCharArray()) {
            stack.append(c);

            if (stack.length() >= 2 * k) {
                int start = stack.length() - 2 * k;
                String lastPart = stack.substring(start);

                if (lastPart.equals(toRemove)) {
                    stack.delete(start, stack.length());
                }
            }
        }

        return stack.toString();
    }
}

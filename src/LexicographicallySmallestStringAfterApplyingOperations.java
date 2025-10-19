import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 */

public class LexicographicallySmallestStringAfterApplyingOperations {

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            String add = add(str, a);
            String rotate = rotate(str, b);
            if (!set.contains(add)) {
                set.add(add);
                queue.offer(add);
            }
            if (!set.contains(rotate)) {
                set.add(rotate);
                queue.offer(rotate);
            }
        }
        String ans = s;
        for (String str : set) {
            if (ans.compareTo(str) > 0) {
                ans = str;
            }
        }
        return ans;
    }

    private String add(String str, int a) {
        int n = str.length();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if ((i & 1) != 0) {
                sb.append((char) (chars[i] + a > '9' ? chars[i] + a - 10 : chars[i] + a));
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    private String rotate(String str, int b) {
        return str.substring(str.length() - b) + str.substring(0, str.length() - b);
    }
}

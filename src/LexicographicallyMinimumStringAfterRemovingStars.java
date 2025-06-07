import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
 */

public class LexicographicallyMinimumStringAfterRemovingStars {

    public String clearStars(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<ArrayDeque<Integer>> cnt = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            cnt.add(new ArrayDeque<>());
        }
        int minChar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '*') {
                cnt.get(chars[i] - 'a').push(i);
                minChar = Math.min(minChar, chars[i] - 'a');
            } else {
                chars[cnt.get(minChar).pop()] = '*';
                while (minChar < 26 && cnt.get(minChar).isEmpty()) {
                    minChar++;
                }
            }
        }
        StringBuilder ans = new StringBuilder(s.length());
        for (char c : chars) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

import java.util.HashMap;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 */

public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public int findTheLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int mask = 0;
        int ans = 0;
        Set<Character> set = Set.of('a', 'i', 'e', 'o', 'u');
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (set.contains(chars[i])) {
                mask ^= 1 << (chars[i] - 'a');
                if (!map.containsKey(mask)) {
                    map.put(mask, i);
                }
            }
            ans = Math.max(ans, i - map.get(mask));
        }
        return ans;
    }
}

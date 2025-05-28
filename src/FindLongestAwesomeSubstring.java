import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-longest-awesome-substring/description/
 */

public class FindLongestAwesomeSubstring {

    public int longestAwesome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mask = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (chars[i] - '0');
            if (map.containsKey(mask)) {
                ans = Math.max(ans, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
            for (int j = 0; j < 10; j++) {
                int key = mask ^ (1 << j);
                ans = Math.max(ans, i - map.getOrDefault(key, i));
            }
        }
        return ans;
    }
}

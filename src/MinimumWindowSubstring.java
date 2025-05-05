import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-window-substring/description/
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (m < n) {
            return "";
        }
        for (int i = 0; i < n; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int min = Integer.MAX_VALUE, index = 0;
        for (int right = n; right <= m; right++) {
            while (isSubstring(sMap, tMap) && left < right) {
                if (min > right - left) {
                    min = right - left;
                    index = left;
                }
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }
            if (right < m) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
        }
        min = min == Integer.MAX_VALUE ? 0 : min;
        return s.substring(index, index + min);
    }

    private boolean isSubstring(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (char c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}

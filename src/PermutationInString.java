import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int size = s1.length();
        if (size > s2.length()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (int i = size; i <= s2.length(); i++) {
            boolean flag = true;
            for (char c : map1.keySet()) {
                if (!Objects.equals(map1.get(c), map2.get(c))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            if (i < s2.length()) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
                map2.put(s2.charAt(i - size), map2.getOrDefault(s2.charAt(i - size), 0) - 1);
            }
        }
        return false;
    }
}

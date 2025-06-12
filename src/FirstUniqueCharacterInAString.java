import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<int[]> list = new ArrayList<>();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            if (freq[chars[i] - 'a'] == 0) {
                list.add(new int[]{i, chars[i]});
            }
            freq[chars[i] - 'a']++;
        }
        for (int[] i : list) {
            if (freq[i[1] - 'a'] == 1) {
                return i[0];
            }
        }
        return -1;
    }
}

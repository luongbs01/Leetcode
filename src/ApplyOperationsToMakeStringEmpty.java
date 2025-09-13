import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/apply-operations-to-make-string-empty/description/
 */

public class ApplyOperationsToMakeStringEmpty {

    public String lastNonEmptyString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] freq = new int[26], lastOccur = new int[26];
        for (int i = 0; i < n; i++) {
            freq[chars[i] - 'a']++;
            lastOccur[chars[i] - 'a'] = i;
        }
        int maxFreq = 0;
        for (int i : freq) {
            maxFreq = Math.max(maxFreq, i);
        }
        TreeMap<Integer, Character> treeMap = new TreeMap<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                treeMap.put(lastOccur[i], (char) (i + 'a'));
            }
        }
        StringBuilder ans = new StringBuilder(26);
        for (Character c : treeMap.values()) {
            ans.append(c);
        }
        return ans.toString();
    }
}

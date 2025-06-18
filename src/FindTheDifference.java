/**
 * Description: https://leetcode.com/problems/find-the-difference/description/
 */

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (char c : t.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (cnt[c - 'a'] > 0) {
                return c;
            }
        }
        return 0;
    }
}

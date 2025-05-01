/**
 * Description: https://leetcode.com/problems/valid-anagram/description/
 */

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] sChar = getNumOfOccurrence(s);
        int[] tChar = getNumOfOccurrence(t);
        for (int i = 0; i < 26; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getNumOfOccurrence(String s) {
        int[] res = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            res[s.charAt(i) - 'a']++;
        }
        return res;
    }
}

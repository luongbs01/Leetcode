/**
 * Description: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 */

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        int ans = 0;
        for (int i : cnt) {
            ans += Math.abs(i);
        }
        return ans / 2;
    }
}

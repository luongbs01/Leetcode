/**
 * Description: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/
 */

public class FindMostFrequentVowelAndConsonant {

    public int maxFreqSum(String s) {
        int[] count = new int[26];
        int maxFreqVowel = 0, maxFreqConsonant = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (isVowel(c)) {
                maxFreqVowel = Math.max(maxFreqVowel, count[c - 'a']);
            } else {
                maxFreqConsonant = Math.max(maxFreqConsonant, count[c - 'a']);
            }
        }
        return maxFreqVowel + maxFreqConsonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

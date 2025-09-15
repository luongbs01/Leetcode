/**
 * Description: https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/
 */

public class MaximumNumberOfWordsYouCanType {

    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        int ans = 0;
        boolean canType = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                ans += canType ? 1 : 0;
                canType = true;
            } else if (broken[c - 'a']) {
                canType = false;
            }
        }
        ans += canType ? 1 : 0;
        return ans;
    }
}

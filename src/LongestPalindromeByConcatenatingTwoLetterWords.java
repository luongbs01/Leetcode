import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
 */

public class LongestPalindromeByConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            String reversed = new String(new char[]{word.charAt(1), word.charAt(0)});
            if (map.getOrDefault(reversed, 0) > 0) {
                ans += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            String word = new String(new char[]{c, c});
            if (map.getOrDefault(word, 0) > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}

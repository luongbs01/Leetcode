import java.util.HashSet;

/**
 * Description: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> charSet = new HashSet<>();
        char[] charArr = s.toCharArray();
        int i = 0, j = 0, length = charArr.length;
        while (j < length) {
            while (j < length && !charSet.contains(charArr[j])) {
                charSet.add(charArr[j]);
                j++;
            }
            ans = Math.max(ans, j - i);
            while (i < j && j < length && charSet.contains(charArr[j])) {
                charSet.remove(charArr[i]);
                i++;
            }
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description: https://leetcode.com/problems/sort-vowels-in-a-string/description/
 */

public class SortVowelsInAString {

    public String sortVowels(String s) {
        int n = s.length(), index = 0;
        char[] chars = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>(n);
        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        for (int i = 0; i < n; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(index++);
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

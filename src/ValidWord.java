import java.util.Set;

/**
 * Description: https://leetcode.com/problems/valid-word/description/
 */

public class ValidWord {

    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        int cntVowel = 0, cntConsonant = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.contains(c)) {
                    cntVowel++;
                } else {
                    cntConsonant++;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return cntVowel > 0 && cntConsonant > 0;
    }
}

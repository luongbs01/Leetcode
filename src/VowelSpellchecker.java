import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/vowel-spellchecker/description/
 */

public class VowelSpellchecker {

    Map<String, String> exactMatch = new HashMap<>();
    Map<String, String> capitalizationMatch = new HashMap<>();
    Map<String, String> vowelErrorsMatch = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (int i = wordlist.length - 1; i >= 0; i--) {
            exactMatch.put(wordlist[i], wordlist[i]);
            capitalizationMatch.put(wordlist[i].toUpperCase(), wordlist[i]);
            vowelErrorsMatch.put(toAsteriskUppercase(wordlist[i]), wordlist[i]);
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (exactMatch.containsKey(queries[i])) ans[i] = queries[i];
            else if (capitalizationMatch.containsKey(queries[i].toUpperCase()))
                ans[i] = capitalizationMatch.get(queries[i].toUpperCase());
            else ans[i] = vowelErrorsMatch.getOrDefault(toAsteriskUppercase(queries[i]), "");
        }
        return ans;
    }

    private String toAsteriskUppercase(String str) {
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (isVowel(c)) sb.append("*");
            else sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-words-containing-character/description/
 */

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}

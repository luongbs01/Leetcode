import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 */

public class EvaluateTheBracketPairsOfAString {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder ans = new StringBuilder(s.length());
        StringBuilder key = new StringBuilder(10);
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                flag = true;
            } else if (c == ')') {
                String val = map.get(key.toString());
                ans.append(val != null ? val : '?');
                flag = false;
                key = new StringBuilder(10);
            } else if (flag) {
                key.append(c);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

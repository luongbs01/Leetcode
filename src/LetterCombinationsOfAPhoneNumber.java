import java.util.*;

/**
 * Description: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */

public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, String> map;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> ans = new LinkedList<>();
        map = new HashMap<>();
        initData();
        backtrack(0, new StringBuilder(digits.length()), digits, ans);
        return ans;
    }

    private void backtrack(int index, StringBuilder s, String digit, List<String> ans) {
        if (index == digit.length()) {
            ans.add(s.toString());
        } else {
            String val = map.get(digit.charAt(index) - '0');
            for (char c : val.toCharArray()) {
                s.append(c);
                backtrack(index + 1, s, digit, ans);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    private void initData() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}

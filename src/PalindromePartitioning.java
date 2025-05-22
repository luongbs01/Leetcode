import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/palindrome-partitioning/description/
 */

public class PalindromePartitioning {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, new ArrayList<>(), s);
        return ans;
    }

    private void backtrack(int i, List<String> list, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    list.add(substring);
                    backtrack(j, list, s);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

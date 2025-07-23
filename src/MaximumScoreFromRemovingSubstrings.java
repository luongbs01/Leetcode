/**
 * Description: https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
 */

public class MaximumScoreFromRemovingSubstrings {

    int ans = 0;

    public int maximumGain(String s, int x, int y) {
        String substring = x > y ? "ab" : "ba";
        int score = Math.max(x, y);
        s = remove(s, substring, score);
        substring = x > y ? "ba" : "ab";
        score = Math.min(x, y);
        remove(s, substring, score);
        return ans;
    }

    private String remove(String s, String substring, int score) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int n = s.length();
        char c0 = substring.charAt(0), c1 = substring.charAt(1);
        for (int i = 0; i < n; i++) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c0 && chars[i] == c1) {
                ans += score;
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}

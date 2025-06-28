/**
 * Description: https://leetcode.com/problems/longest-subsequence-repeated-k-times/description/
 */

public class LongestSubsequenceRepeatedKTimes {

    int n;
    String ans = "", s;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s;
        n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = Math.min(7, s.length() / k); i >= 1; i--) {
            if ("".equals(ans)) {
                StringBuilder sb = new StringBuilder(i);
                gen(i, k, freq, sb);
            }
        }
        return ans;
    }

    private void gen(int length, int k, int[] freq, StringBuilder sb) {
        if (sb.length() == length && "".equals(ans)) {
            if (isValid(s, sb.toString(), k)) {
                ans = sb.toString();
            }
        } else {
            for (int j = 25; j >= 0; j--) {
                if (freq[j] >= k) {
                    sb.append((char) ('a' + j));
                    freq[j] -= k;
                    gen(length, k, freq, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    freq[j] += k;
                }
            }
        }
    }

    private boolean isValid(String s, String seq, int k) {
        char[] sChars = s.toCharArray();
        char[] seqChars = seq.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < n; i++) {
            if (sChars[i] == seqChars[j]) {
                j++;
            }
            if (j == seq.length()) {
                j = 0;
                cnt++;
                if (cnt >= k) {
                    return true;
                }
            }
        }
        return false;
    }
}

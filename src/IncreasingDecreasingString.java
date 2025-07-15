/**
 * Description: https://leetcode.com/problems/increasing-decreasing-string/description/
 */

public class IncreasingDecreasingString {

    public String sortString(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        while (length > 0) {
            int minChar = 0;
            while (minChar < 26) {
                if (freq[minChar] > 0) {
                    sb.append((char) (minChar + 'a'));
                    freq[minChar]--;
                    length--;
                }
                minChar++;
            }
            int maxChar = 25;
            while (maxChar >= 0) {
                if (freq[maxChar] > 0) {
                    sb.append((char) (maxChar + 'a'));
                    freq[maxChar]--;
                    length--;
                }
                maxChar--;
            }
        }
        return sb.toString();
    }
}

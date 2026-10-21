/**
 * Description: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
 */

public class MinimumOperationsToSortAString {

    public int minOperations(String s) {
        int n = s.length(), minChar = 26, maxChar = -1;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                minChar = Math.min(minChar, i);
                maxChar = Math.max(maxChar, i);
                sorted.repeat((char) (i + 'a'), cnt[i]);
            }
        }
        if (s.contentEquals(sorted)) {
            return 0;
        }
        if (s.length() == 2 && s.charAt(0) > s.charAt(1)) {
            return -1;
        }
        if (s.charAt(0) - 'a' == maxChar && s.charAt(n - 1) - 'a' == minChar && cnt[minChar] == 1 && cnt[maxChar] == 1) {
            return 3;
        } else if (s.charAt(0) - 'a' == minChar || s.charAt(n - 1) - 'a' == maxChar) {
            return 1;
        }
        return 2;
    }
}

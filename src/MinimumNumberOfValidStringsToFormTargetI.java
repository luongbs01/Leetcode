import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-valid-strings-to-form-target-i/description/
 */

public class MinimumNumberOfValidStringsToFormTargetI {

    public int minValidStrings(String[] words, String target) {
        Trie root = new Trie();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int i = 0;
            Trie curr = root;
            while (i < chars.length && curr.children[chars[i] - 'a'] != null) {
                curr = curr.children[chars[i] - 'a'];
                i++;
            }
            while (i < chars.length) {
                curr.children[chars[i] - 'a'] = new Trie();
                curr = curr.children[chars[i] - 'a'];
                i++;
            }
        }
        int n = target.length();
        int[] dp = new int[n + 1]; // dp[i] minimum cost to form the prefix of length i of target
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        char[] chars = target.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = i;
            Trie curr = root;
            while (dp[i] != Integer.MAX_VALUE && j < n && curr.children[chars[j] - 'a'] != null) {
                curr = curr.children[chars[j] - 'a'];
                j++;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n] != Integer.MAX_VALUE ? dp[n] : -1;
    }

    private static class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[26];
        }
    }
}

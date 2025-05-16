import java.util.List;

/**
 * Description: https://leetcode.com/problems/word-break/description/
 */

public class WordBreak {

    Trie trie;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        int length = s.length();
        dp = new boolean[length];
        char[] chars = s.toCharArray();
        for (String word : wordDict) {
            trie.insert(word);
        }
        search(trie, chars, 0);
        for (int i = 1; i < length; i++) {
            if (dp[i - 1]) {
                search(trie, chars, i);
            }
        }
        return dp[length - 1];
    }

    public void search(Trie node, char[] chars, int index) {
        while (index < chars.length && node.children[chars[index] - 'a'] != null) {
            node = node.children[chars[index] - 'a'];
            if (node.isWord) {
                dp[index] = true;
            }
            index++;
        }
    }

    class Trie {
        boolean isWord;
        Trie[] children;

        public Trie() {
            isWord = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
}

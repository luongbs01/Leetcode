/**
 * Description: https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */

public class ImplementTrie {

    public ImplementTrie() {

    }

    public static class Trie {

        boolean isTerminal;
        Trie[] children;

        public Trie() {
            isTerminal = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie child = this;
            char[] chars = word.toCharArray();
            int index = 0;
            while (index < chars.length && child.children[chars[index] - 'a'] != null) {
                child = child.children[chars[index] - 'a'];
                index++;
            }
            while (index < chars.length) {
                child.children[chars[index] - 'a'] = new Trie();
                child = child.children[chars[index] - 'a'];
                index++;
            }
            child.isTerminal = true;
        }

        public boolean search(String word) {
            int index = 0;
            char[] chars = word.toCharArray();
            Trie child = this;
            while (index < chars.length && child.children[chars[index] - 'a'] != null) {
                child = child.children[chars[index] - 'a'];
                index++;
            }
            return index == chars.length && child.isTerminal;
        }

        public boolean startsWith(String prefix) {
            int index = 0;
            char[] chars = prefix.toCharArray();
            Trie child = this;
            while (index < chars.length && child.children[chars[index] - 'a'] != null) {
                child = child.children[chars[index] - 'a'];
                index++;
            }
            return index == chars.length;
        }
    }
}

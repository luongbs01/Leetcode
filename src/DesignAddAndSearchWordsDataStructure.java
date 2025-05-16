import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */

public class DesignAddAndSearchWordsDataStructure {

    class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode trieNode = root;
            for (char c : word.toCharArray()) {
                if (!trieNode.children.containsKey(c)) {
                    trieNode.children.put(c, new TrieNode());
                }
                trieNode = trieNode.children.get(c);
            }
            trieNode.isEndOfWord = true;
        }

        public boolean search(String word) {
            return search(root, word.toCharArray(), 0);
        }

        public boolean search(TrieNode node, char[] word, int index) {
            if (index == word.length) {
                return node.isEndOfWord;
            }
            if (word[index] != '.' && !node.children.containsKey(word[index])) {
                return false;
            }
            if (word[index] == '.') {
                for (char c : node.children.keySet()) {
                    if (search(node.children.get(c), word, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
            return search(node.children.get(word[index]), word, index + 1);
        }

        class TrieNode {
            boolean isEndOfWord;
            HashMap<Character, TrieNode> children;

            public TrieNode() {
                isEndOfWord = false;
                children = new HashMap<>();
            }
        }
    }
}

/**
 * Description: https://leetcode.com/problems/longest-common-suffix-queries/
 */

public class LongestCommonSuffixQueries {

	class Trie {
		int index = 0;
		Trie[] children = new Trie[26];

		void insert(int currIndex, String[] wordsContainer) {
			Trie currNode = this;
			char[] word = wordsContainer[currIndex].toCharArray();
			int i = word.length - 1;
			if (word.length < wordsContainer[currNode.index].length()) {
				currNode.index = currIndex;
			}
			for (; i >= 0 && currNode.children[word[i] - 'a'] != null; i--) {
				currNode = currNode.children[word[i] - 'a'];
				if (word.length < wordsContainer[currNode.index].length()) {
					currNode.index = currIndex;
				}
			}
			for (; i >= 0; i--) {
				Trie node = new Trie();
				currNode.children[word[i] - 'a'] = node;
				currNode = node;
				currNode.index = currIndex;
			}
		}

		int find(char[] word) {
			Trie currNode = this;
			for (int i = word.length - 1; i >= 0 && currNode.children[word[i] - 'a'] != null; i--) {
				currNode = currNode.children[word[i] - 'a'];
			}
			return currNode.index;
		}
	}

	public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
		Trie root = new Trie();
		for (int i = 0; i < wordsContainer.length; i++) {
			root.insert(i, wordsContainer);
		}
		int n = wordsQuery.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = root.find(wordsQuery[i].toCharArray());
		}
		return ans;
	}
}

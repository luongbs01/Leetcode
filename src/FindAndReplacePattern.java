import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-and-replace-pattern/
 */

public class FindAndReplacePattern {

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> ans = new ArrayList<>(words.length);
		for (String word : words) {
			if (match(word, pattern)) {
				ans.add(word);
			}
		}
		return ans;
	}

	private boolean match(String word, String pattern) {
		int[] permutation = new int[26];
		boolean[] used = new boolean[26];
		Arrays.fill(permutation, -1);
		for (int i = 0; i < word.length(); i++) {
			if (permutation[pattern.charAt(i) - 'a'] == -1 && !used[word.charAt(i) - 'a']) {
				permutation[pattern.charAt(i) - 'a'] = word.charAt(i) - 'a';
				used[word.charAt(i) - 'a'] = true;
			} else if (permutation[pattern.charAt(i) - 'a'] != word.charAt(i) - 'a') {
				return false;
			}
		}
		return true;
	}
}

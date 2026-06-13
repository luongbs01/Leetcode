/**
 * Description: https://leetcode.com/problems/weighted-word-mapping/
 */

public class WeightedWordMapping {

	public String mapWordWeights(String[] words, int[] weights) {
		int n = words.length;
		StringBuilder ans = new StringBuilder(n);
		for (String word : words) {
			int weight = 0;
			for (char c : word.toCharArray()) {
				weight += weights[c - 'a'];
			}
			ans.append((char) ('a' + 25 - weight % 26));
		}
		return ans.toString();
	}
}

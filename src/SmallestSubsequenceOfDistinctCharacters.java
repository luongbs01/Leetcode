import java.util.ArrayDeque;

/**
 * Description: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

public class SmallestSubsequenceOfDistinctCharacters {

	public String smallestSubsequence(String s) {
		char[] chars = s.toCharArray();
		boolean[] seen = new boolean[26];
		int[] freq = new int[26];
		for (char c : chars) {
			freq[c - 'a']++;
		}
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (char c : chars) {
			int idx = c - 'a';
			freq[idx]--;
			if (seen[idx])
				continue;
			while (!stack.isEmpty()) {
				if (stack.peek() <= c) {
					break;
				}
				if (freq[stack.peek() - 'a'] == 0) {
					break;
				}
				seen[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			seen[idx] = true;
		}

		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty()) {
			ans.append(stack.poll());
		}
		return ans.reverse().toString();
	}
}

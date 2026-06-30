import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */

public class NumberOfSubstringsContainingAllThreeCharacters {

	public int numberOfSubstrings(String s) {
		int n = s.length(), ans = 0;
		char[] chars = s.toCharArray();
		int[] lastOccurrence = new int[3];
		Arrays.fill(lastOccurrence, -1);
		for (int i = 0; i < n; i++) {
			int min = 50_000;
			for (int j = 0; j < 3; j++) {
				if (j != (chars[i] - 'a')) {
					min = Math.min(min, lastOccurrence[j]);
				}
			}
			ans += (min + 1);
			lastOccurrence[chars[i] - 'a'] = i;
		}
		return ans;
	}
}

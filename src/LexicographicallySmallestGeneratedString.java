import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/lexicographically-smallest-generated-string/
 */

public class LexicographicallySmallestGeneratedString {

	public String generateString(String str1, String str2) {
		int n = str1.length(), m = str2.length();
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int[] word = new int[n + m - 1];
		Arrays.fill(word, -1);
		boolean[] fixed = new boolean[n + m - 1];
		for (int i = 0; i < n; i++) {
			if (chars1[i] == 'T') {
				for (int j = i; j < i + m; j++) {
					if (word[j] == -1) {
						word[j] = chars2[j - i] - 'a';
						fixed[j] = true;
					} else if (word[j] != chars2[j - i] - 'a') {
						return "";
					}
				}
			}
		}
		for (int i = 0; i < word.length; i++) {
			if (word[i] == -1) {
				word[i] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (chars1[i] == 'F') {
				boolean isEqual = true;
				int max = i - 1;
				for (int j = i + m - 1; j >= i; j--) {
					if (word[j] != chars2[j - i] - 'a') {
						isEqual = false;
					}
					if (!fixed[j]) {
						max = Math.max(max, j);
					}
				}
				if (isEqual && max == i - 1) {
					return "";
				} else if (isEqual && max > i - 1) {
					word[max] = 1;
				}
			}
		}
		StringBuilder ans = new StringBuilder(word.length);
		for (int i : word) {
			ans.append((char) (i + 'a'));
		}
		return ans.toString();
	}
}

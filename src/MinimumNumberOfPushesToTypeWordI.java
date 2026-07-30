import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 */

public class MinimumNumberOfPushesToTypeWordI {

	public int minimumPushes(String word) {
		int ans = 0, n = word.length();
		char[] chars = word.toCharArray();
		int[][] freq = new int[26][2];
		for (int i = 1; i < 26; i++) {
			freq[i][0] = i;
		}
		for (int i = 0; i < n; i++) {
			freq[chars[i] - 'a'][1]++;
		}
		Arrays.sort(freq, (o1, o2) -> o2[1] - o1[1]);

		int[] minPushes = new int[26];
		for (int i = 0; i < 26; i++) {
			minPushes[freq[i][0]] = (i + 8) / 8;
		}
		for (int i = 0; i < n; i++) {
			ans += minPushes[chars[i] - 'a'];
		}
		return ans;
	}

	public int minimumPushesV2(String word) {
		int ans = 0;
		int[][] freq = new int[26][1];
		for (char c : word.toCharArray()) {
			freq[c - 'a'][0]++;
		}
		Arrays.sort(freq, (o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < 26; i++) {
			ans += freq[i][0] * ((i + 8) / 8);
		}
		return ans;
	}
}

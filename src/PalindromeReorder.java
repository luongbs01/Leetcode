import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1755
 */

public class PalindromeReorder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'A']++;
		}
		int cnt = 0, pos = -1;
		for (int i = 0; i < 26; i++) {
			if (freq[i] % 2 != 0) {
				cnt++;
				pos = i;
			}
		}
		if (cnt > 1) {
			System.out.print("NO SOLUTION");
		} else {
			StringBuilder ans = new StringBuilder(s.length() / 2);
			for (int i = 0; i < 26; i++) {
				if (freq[i] > 0) {
					ans.append(String.valueOf((char) (i + 'A')).repeat(freq[i] >> 1));
					freq[i] >>= 1;
				}
			}
			if (pos != -1) {
				ans.append((char) (pos + 'A'));
			}
			for (int i = 25; i >= 0; i--) {
				if (freq[i] > 0) {
					ans.append(String.valueOf((char) (i + 'A')).repeat(freq[i]));
					freq[i] >>= 1;
				}
			}
			System.out.print(ans);
		}
	}
}

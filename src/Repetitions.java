import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1069
 */

public class Repetitions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		char[] chars = s.toCharArray();
		int n = chars.length, ans = 1, cnt = 1;
		for (int i = 1; i < n; i++) {
			if (chars[i - 1] != chars[i]) {
				ans = Math.max(ans, cnt);
				cnt = 1;
			} else {
				cnt++;
			}
		}
		System.out.println(Math.max(ans, cnt));
	}
}

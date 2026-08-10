import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1083
 */

public class MissingNumberCSES {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ans = 0;
		for (int i = 1; i < n; i++) {
			int j = scanner.nextInt();
			ans ^= i;
			ans ^= j;
		}
		System.out.println(ans ^ n);
	}
}

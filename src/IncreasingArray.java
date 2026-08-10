import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1094
 */

public class IncreasingArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long ans = 0, prev = 0;
		for (int i = 0; i < n; i++) {
			long j = scanner.nextInt();
			if (j < prev) {
				ans += (prev - j);
			} else if (j > prev) {
				prev = j;
			}
		}
		System.out.println(ans);
	}
}

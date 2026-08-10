import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1070
 */

public class PermutationsCSES {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n == 1) {
			System.out.print("1");
		} else if (n < 4) {
			System.out.print("NO SOLUTION");
		} else {
			StringBuilder ans = new StringBuilder();
			ans.append("2");
			for (int i = 4; i <= n; i += 2) {
				ans.append(" " + i);
			}
			for (int i = 1; i <= n; i += 2) {
				ans.append(" " + i);
			}
			System.out.print(ans);
		}
	}
}

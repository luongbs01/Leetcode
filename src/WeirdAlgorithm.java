import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1068/
 */

public class WeirdAlgorithm {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextInt();
		System.out.print(n);
		while (n != 1) {
			if ((n & 1) != 0) {
				n = n * 3 + 1;
			} else {
				n >>= 1;
			}
			System.out.print(" " + n);
		}
	}
}

import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1617
 */

public class BitStrings {

	public static final long MOD = 1_000_000_007;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextInt();
		System.out.print(pow(2, n));
	}

	private static long pow(long base, long i) {
		if (i == 1)
			return base;
		long j = pow(base, i >> 1);
		if ((i & 1) != 0) {
			return (j * j * base) % MOD;
		} else {
			return (j * j) % MOD;
		}
	}
}

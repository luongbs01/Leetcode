import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1722
 */

public class FibonacciNumbers {

	public static final long MOD = 1_000_000_007;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		if (n < 2) {
			System.out.print(n);
			return;
		}
		long[][] A = new long[][] { { 1, 1 }, { 1, 0 } };
		long[][] B = pow(A, n - 1);
		System.out.print(B[0][0]);
	}

	private static long[][] pow(long[][] a, long b) {
		if (b == 1) {
			return a;
		}
		long[][] i = pow(a, b >> 1);
		if ((b & 1) != 0) {
			return multiply(multiply(i, i), a);
		}
		return multiply(i, i);
	}

	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] res = new long[2][2];
		res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
		res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
		res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
		res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
		return res;
	}
}

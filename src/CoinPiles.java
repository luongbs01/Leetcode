import java.io.IOException;
import java.io.InputStream;

/**
 * Description: https://cses.fi/problemset/task/1754
 */

public class CoinPiles {

	public static void main(String[] args) throws IOException {
		FastScanner scanner = new FastScanner();
		StringBuilder ans = new StringBuilder();
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			ans.append(valid(a, b) ? "YES" : "NO");
			ans.append("\n");
		}
		System.out.print(ans);
	}

	private static boolean valid(int a, int b) {
		if ((a + b) % 3 != 0) {
			return false;
		}
		return Math.abs(a - b) <= (a + b) / 3;
	}

	static class FastScanner {
		private final InputStream in = System.in;
		private final byte[] buffer = new byte[1 << 16]; // Buffer 64KB
		private int bufferPointer = 0, bytesRead = 0;

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				bufferPointer = 0;
				bytesRead = in.read(buffer, 0, buffer.length);
				if (bytesRead == -1)
					buffer[0] = -1;
			}
			return buffer[bufferPointer++];
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				if (c == -1)
					return -1;
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
	}
}

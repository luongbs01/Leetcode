import java.io.IOException;
import java.io.InputStream;

/**
 * Description: https://cses.fi/problemset/task/1647
 */

public class StaticRangeMinimumQueries {

	public static void main(String[] args) throws IOException {
		FastScanner scanner = new FastScanner();
		StringBuilder ans = new StringBuilder();
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		int[] arr = new int[n];
		int[] seg = new int[n << 2];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			arr[i] = a;
		}
		build(arr, seg, 0, n - 1, 1);

		for (int i = 0; i < q; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			ans.append(query(seg, 0, n - 1, 1, a - 1, b - 1));
			ans.append("\n");
		}
		System.out.print(ans);
	}

	private static void build(int[] arr, int[] seg, int l, int r, int idx) {
		if (l == r) {
			seg[idx] = arr[l];
			return;
		}
		int mid = (l + r) >> 1;
		build(arr, seg, l, mid, idx << 1);
		build(arr, seg, mid + 1, r, (idx << 1) | 1);
		seg[idx] = Math.min(seg[idx << 1], seg[(idx << 1) | 1]);
	}

	private static int query(int[] seg, int l, int r, int idx, int L, int R) {
		if (L <= l && R >= r) {
			return seg[idx];
		}
		if (L > r || R < l) {
			return Integer.MAX_VALUE;
		}
		int mid = (l + r) >> 1;
		return Math.min(query(seg, l, mid, idx << 1, L, R), query(seg, mid + 1, r, (idx << 1) | 1, L, R));
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
